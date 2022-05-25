package com.debug.steadyjack.listener;


/**
 * spring boot 事件驱动模型
 *
 * 一、理论
 * 1、事件包括：
 * event（事件） 相当于rabbitmq的 message
 * pulisher（事件发布者） 相当于rabbitmq的 rabbitTemplate（使用它，service就具备了发布事件的能力）
 * listener（事件订阅者）相当于rabbitmq的listener（消费者，监听者）
 *
 * 2、spring boot 事件的 三大组件
 * （1）ApplicationEvent -- 事件，抽象类，自己的事件类继承它
 * （2）ApplicationListener -- 事件监听器，接口
 * （3）ApplicationEventPublisher -- 发布者，类似于rabbitmq的rabbitTemplate
 *
 * 二、演示
 * PushOrderRecordEvent -- 自定义的事件
 * PushOrderRecordListener -- 自定义的事件监听器
 *
 * 测试类「OrderRecordController」 -- pulisher
 *
 * http://localhost:9092/order/push
 * 监听到的下单记录： PushOrderRecordEvent{orderNo='orderNo_c8940b20-3282-4207-b0f9-9e738ba73721', orderType='物流12'}
 *
 * 这是同步操作：PushOrderRecordListener监听器没有处理完之前，OrderRecordController不会成功返回。
 *
 *
 * 小技巧：
 * 1、BeanUtils.copyProperties(event, entity);
 *   BeanUtils是spring的类，实现对象的拷贝
 */