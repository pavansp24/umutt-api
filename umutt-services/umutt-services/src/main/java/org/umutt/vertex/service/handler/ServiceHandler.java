package org.umutt.vertex.service.handler;

import org.umutt.spring.service.UmuttAsyncService;

import io.vertx.ext.web.RoutingContext;

public class ServiceHandler {

	private RoutingContext context;
	
	private UmuttAsyncService asyncService;
	
	public ServiceHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public UmuttAsyncService getAsyncService() {
		return asyncService;
	}
	
	public RoutingContext getContext() {
		return context;
	}
	
	public void setAsyncService(UmuttAsyncService asyncService) {
		this.asyncService = asyncService;
	}
	
	public void setContext(RoutingContext context) {
		this.context = context;
	}
	
	public void performHttpActionRequest() {
		
	}
}
