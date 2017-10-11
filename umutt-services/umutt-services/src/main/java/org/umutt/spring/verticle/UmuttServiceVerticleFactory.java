package org.umutt.spring.verticle;

import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UmuttServiceVerticleFactory implements VerticleFactory,
		ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.applicationContext = arg0;
	}

	@Override
	public boolean blockingCreate() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 @Override
	  public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception {
	    String clazz = VerticleFactory.removePrefix(verticleName);
	    return (Verticle) applicationContext.getBean(Class.forName(clazz));
	  }
	@Override
	public String prefix() {
		// TODO Auto-generated method stub
		return "umutt";
	}

}
