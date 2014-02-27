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
public class HelloWorldSend {
	 private final static String QUEUE_NAME = "helloWorld";
	 public final static void sender() throws IOException{
		    ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("192.168.115.128");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    String message = "Hello World!";
		    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		    System.out.println(" [x] Sent '" + message + "'");
		    channel.close();
		    connection.close();
	 }
	 public static void main(String[] args) throws IOException {
		 sender();
	}
}
