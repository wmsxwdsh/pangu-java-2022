package com.debug.steadyjack.rabbitmq;

import com.debug.steadyjack.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/29.
 */
@Component("simpleListener")
public class SimpleListener implements ChannelAwareMessageListener {

    private static final Logger log = LoggerFactory.getLogger(SimpleListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // deliveryTag：long - 消息投递的唯一标识，作用域为当前channel。默认为1
        long tag = message.getMessageProperties().getDeliveryTag();

        try {
            byte[] msg = message.getBody();
            User user = objectMapper.readValue(msg, User.class);
            log.info("简单消息监听确认机制监听到消息： {} ", user);

//            int i = 1 / 0;

            channel.basicAck(tag, true);
        } catch (Exception e) {
            log.error("简单消息监听确认机制发生异常：", e.fillInStackTrace());

            /**
             * basic.reject方法拒绝deliveryTag对应的消息
             * true则重新入队列，
             * false丢弃或者进入死信队列。
             * 该方法reject后，该消费者还是会消费到该条被reject的消息。
             */
            channel.basicReject(tag, false);

            /**
             *  basic.recover是否恢复消息到队列
             *  true则重新入队列，并且尽可能的将之前recover的消息投递给其他消费者消费，而不是自己再次消费。
             *  false则消息会重新被投递给自己。
             */
            channel.basicRecover(true);
        }
    }
}
































