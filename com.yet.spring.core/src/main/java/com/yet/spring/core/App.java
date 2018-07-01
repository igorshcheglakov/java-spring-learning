package com.yet.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private Client client;
	private EventLogger eventLogger;
	
	public App(Client client, EventLogger eventLogger) {
		super();
		this.client = client;
		this.eventLogger = eventLogger;
	}
	
	private void logEvent(Event event, String message) {
		
		String logMsg = message.replaceAll(client.getId(), client.getFullName());
		event.setMsg(logMsg);
		
		eventLogger.logEvent(event);
	}
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		App app = (App) ctx.getBean("app");
		
		Event event = ctx.getBean(Event.class);
		app.logEvent(event, "Some event for user 1");
		
		event = ctx.getBean(Event.class);
		app.logEvent(event, "Some event for user 2");
		
		ctx.close();
	}
}
