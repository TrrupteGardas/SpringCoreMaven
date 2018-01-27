package spring.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.di.service.MessageService;

/*
 * A Consumer class for consuming MessageService.
 */

@Component
public class MyApplication {
	
	// field-based dependency injection
	// @Autowired
	private MessageService service;
	
	// constructor-based dependency injection
	// @Autowired
	/*public MyApplication(MessageService service){
		this.service = service;
	}*/
	
	@Autowired
	public void setService(MessageService service){
		this.service = service;
	}
	
	public boolean processMessage(String msg, String receiver){
		return this.service.sendMessage(msg, receiver);
	}
	
}
