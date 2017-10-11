package org.umutt.spring.verticle;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.serviceproxy.ProxyHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.umutt.spring.service.UmuttAsyncService;


@Component
@Scope(SCOPE_PROTOTYPE)
public class UmuttRestWorkerVerticle extends AbstractVerticle {

	private static Logger LOGGER = LoggerFactory.getLogger(UmuttRestWorkerVerticle.class);
	
	@Autowired
	UmuttAsyncService asyncService;
	
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		
		LOGGER.info("Started deploying the umutt worker verticle");
		// TODO Auto-generated method stub
		 ProxyHelper.registerService(UmuttAsyncService.class, vertx, asyncService, UmuttAsyncService.ADDRESS).completionHandler(ar -> {
		      if (ar.succeeded()) {
		    	  LOGGER.info("SpringWorker started");
		        startFuture.complete();
		      } else {
		        startFuture.fail(ar.cause());
		      }
		    });		
		LOGGER.info("completed deploying the umutt worker verticle");

	}
}
