package com.di.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import spring.di.consumer.MyApplication;

/*
 * Client program to test our annotation based Spring Dependency Injection example.
 * AnnotationConfigApplicationContext is the implementation of AbstractApplicationContext 
 * abstract class and it’s used for autowiring the services to components when annotations
 * are used. AnnotationConfigApplicationContext constructor takes Class as argument that
 * will be used to get the bean implementation to inject in component classes.

   getBean(Class) method returns the Component object and uses the configuration for 
   autowiring the objects. Context objects are resource intensive, so we should close 
   them when we are done with it. 
 */
public class ClientApplication {
	
	public static void main(String args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
		MyApplication application = context.getBean(MyApplication.class);
		application.processMessage("Hi Trrupte", "trrupte@gmail.com");
		context.close();
		
	}
	
}
