package com.pangu.mq.rabbit.exchange.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * topic-exchange+routingKey：队列与交换机的绑定-ps有针对性的订阅监听消费 - 路由（具有模式匹配字符）
 *
 * @author steadyjack
 * <p>
 * 在绑定分发消息时exchange的绑定不需要很多个
 */
public class OneProducer {

    private static final String Exchange_Name = "rabbit:mq04:exchange:e01";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String message = "topicExchange-publish我的消息";

            channel.basicPublish(Exchange_Name, "rabbit:mq04:routing:key:r.orange", null, message.getBytes("UTF-8"));
            channel.basicPublish(Exchange_Name, "rabbit:mq04:routing:key:r.orange.apple", null, message.getBytes("UTF-8"));

            System.out.println("生产者发送消息成功---> ");
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
