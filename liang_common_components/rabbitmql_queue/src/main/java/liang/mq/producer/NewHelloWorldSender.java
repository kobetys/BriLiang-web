package liang.mq.producer;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * @ClassName: HelloWorldSend
 * @Description: TODO(发送消息队列)
 * @author BriLiang(liangwen.liang@vipshop.com)
 * @date 2013年11月11日
 */
public class NewHelloWorldSender {
	private final static String QUEUE_NAME = "helloWorld";
	public final static void sender() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.115.128");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = getMessage(new String[]{"H","E","L","L","O","W","O","R","L","D",});
		channel.basicPublish("",QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}

	private static String getMessage(String[] message) {
		if (message.length < 1)
			return "Hello World!";
		return joinStrings(message, ".");
	}

	private static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}

	public static void main(String[] args) throws IOException {
		sender();
	}
}
