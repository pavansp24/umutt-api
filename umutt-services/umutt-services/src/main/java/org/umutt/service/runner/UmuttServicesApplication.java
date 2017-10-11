package org.umutt.service.runner;

import static java.util.concurrent.TimeUnit.SECONDS;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.umutt.spring.verticle.UmuttRestVerticle;
import org.umutt.spring.verticle.UmuttRestWorkerVerticle;
import org.umutt.spring.verticle.UmuttServiceVerticleFactory;

@SpringBootApplication
public class UmuttServicesApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(UmuttServicesApplication.class);
	
	@Value("${vertx.worker.pool.size}")
	int workerPoolSize;

	@Value("${vertx.springWorker.instances}")
	int springWorkerInstances;
	
	@Autowired
	UmuttServiceVerticleFactory factory;

	public static void main(String[] args) {
		SpringApplication.run(UmuttServicesApplication.class, args);
	}
	
	@EventListener
	public void deployVerticles(ApplicationReadyEvent event) {
		
	    Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(workerPoolSize));
	    vertx.registerVerticleFactory(factory);
	    
	    CountDownLatch deployLatch = new CountDownLatch(2);
	    AtomicBoolean failed = new AtomicBoolean(false);

	    String restApiVerticleName = factory.prefix() + ":" + UmuttRestVerticle.class.getName();
	    vertx.deployVerticle(restApiVerticleName, ar -> {
	      if (ar.failed()) {
	        LOGGER.error("Failed to deploy rest verticle", ar.cause());
	        failed.compareAndSet(false, true);
	      }
	      deployLatch.countDown();
	    });

	    DeploymentOptions workerDeploymentOptions = new DeploymentOptions()
	      .setWorker(true)
	      .setInstances(springWorkerInstances);
	    String workerVerticleName = factory.prefix() + ":" + UmuttRestWorkerVerticle.class.getName();
	    vertx.deployVerticle(workerVerticleName, workerDeploymentOptions, ar -> {
	      if (ar.failed()) {
	        LOGGER.error("Failed to deploy worker verticle", ar.cause());
	        failed.compareAndSet(false, true);
	      }
	      deployLatch.countDown();
	    });
	    try {
	        if (!deployLatch.await(200, SECONDS)) { //Let's wait for 20 sec as i am using hikari cp for connection pooling
	          throw new RuntimeException("Timeout waiting for verticle deployments");
	        } else if (failed.get()) {
	          throw new RuntimeException("Failure while deploying verticles");
	        }
	      } catch (InterruptedException e) {
	        throw new RuntimeException(e);
	      }
	    }}
