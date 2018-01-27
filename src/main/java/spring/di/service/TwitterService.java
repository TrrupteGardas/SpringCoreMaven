package spring.di.service;

/*
 * Implementation of MessageService for Twitter
 */
public class TwitterService implements MessageService{

	public boolean sendMessage(String msg, String receiver) {
		System.out.println("Twitter message sent to "+ receiver + " with message=" + msg);
		return true;
	}

}
