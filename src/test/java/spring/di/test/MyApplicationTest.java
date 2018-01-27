package spring.di.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.consumer.MyApplication;
import spring.di.service.MessageService;

/*
 * One of the major benefit of dependency injection in spring is the ease of having mock 
 * service classes rather than using actual services. So I have combined all of the learning 
 * and written everything in a single JUnit 4 test class for dependency injection in spring.
 * 
 * The class is annotated with @Configuration and @ComponentScan annotation because 
 * getMessageService() method returns the MessageService mock implementation. 
 * That’s why getMessageService() is annotated with @Bean annotation.

   Since I am testing MyApplication class that is configured with annotation, I am using 
   AnnotationConfigApplicationContext and creating it’s object in the setUp() method. 
   The context is getting closed in tearDown() method. test() method code is just getting the 
   component object from context and testing it.
 */

@Configuration
@ComponentScan(value={"spring.di.consumer"})
public class MyApplicationTest {
	
	private AnnotationConfigApplicationContext context = null;
	
	@Bean
	public MessageService getMessageService(){
		return (msg, receiver) -> {
			System.out.println("Mock Service");
			return true;
		};		
	}
	
	@Before
	public void setUp() throws Exception{
		context = new AnnotationConfigApplicationContext(MyApplicationTest.class);		
	}
	
	@After
	public void tearDown() throws Exception{
		context.close();
	}
	
	@Test
	public void test(){
		MyApplication app = context.getBean(MyApplication.class);		
		Assert.assertTrue(app.processMessage("Hi Trrupte", "trrupte@gmail.com"));
	}
	
}
