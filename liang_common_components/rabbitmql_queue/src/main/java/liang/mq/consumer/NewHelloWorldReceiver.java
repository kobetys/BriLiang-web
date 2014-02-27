package liang.mq.consumer;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 
 * @ClassName: HelloWorldReceiver
 * @Description: TODO(接受信息)
 * @author BriLiang(liangwen.liang@vipshop.com)
 * @date 2013年11月11日
 */
public class NewHelloWorldReceiver {
	private final static String QUEUE_NAME = "helloWorld";

	public final static void receiver() throws IOException,
			ShutdownSignalException, ConsumerCancelledException,
			InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.115.128");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		boolean autoAck=false;
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
			doWork(message);
			System.out.println(" [x] Done");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}

	private static void doWork(String task) throws InterruptedException {
	    for (char ch: task.toCharArray()) {
	        if (ch == '.') Thread.sleep(1000);
	    }
	}
	public static void main(String[] args) throws ShutdownSignalException,
			ConsumerCancelledException, IOException, InterruptedException {
		receiver();
	}
}
