package com.pangu.mq.rabbit.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;

public class OneConsumer {
    private static final String Queue_Name = "rabbit:mq01:queue";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Queue_Name, true, false, false, null);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("消费端接受到消息---> " + message);
                }
            };

            /**
             * autoAck为false时，RabbitMQ控制台Overview的unacked会有显现
             * 没有ack确认，重新启动该程序会重复消费
             */
            //TODO：autoAck确认消费 -> 这在SpringBoot整合将会进一步的细讲

            channel.basicConsume(Queue_Name, false, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
