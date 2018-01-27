package spring.di.service;

/*
 * Implementation of MessageService for Email
 */
public class EmailService implements MessageService {

	public boolean sendMessage(String msg, String receiver) {
		System.out.println("Email sent to " + receiver + " with message="+ msg);
		return true;
	}

}
