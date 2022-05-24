package com.pangu.mq.rabbit.exchange.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Fanout模式，分意识分发消息模型
 * 有没有rouctingKey都一样
 * 实际场景不大使用
 */
public class OneProducer {

    private static final String Exchange_Name = "rabbit:mq02:exchange:e01";

    private static final String Queue_Name_01 = "rabbit:mq02:queue:q01";
    private static final String Queue_Name_02 = "rabbit:mq02:queue:q02";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            //TODO：fanout-exchange无意识分发消息模型
            channel.exchangeDeclare(Exchange_Name, BuiltinExchangeType.FANOUT);

            // TODO: 绑定队列01
            channel.queueDeclare(Queue_Name_01, true, false, false, null);
            channel.queueBind(Queue_Name_01, Exchange_Name, "");

            // TODO: 绑定队列02
            channel.queueDeclare(Queue_Name_02, true, false, false, null);
            channel.queueBind(Queue_Name_02, Exchange_Name, "");

            String message = "fanoutExchange-publish的消息";
            channel.basicPublish(Exchange_Name, "", null, message.getBytes("UTF-8"));

            System.out.println("生产者发送消息成功---> ");
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

