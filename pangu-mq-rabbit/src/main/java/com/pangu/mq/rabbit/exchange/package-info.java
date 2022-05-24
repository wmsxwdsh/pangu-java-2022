package com.pangu.mq.rabbit.exchange;

/**
 * 1、direct exchange
 * 点对点，一个routing key绑定一个队列
 *
 * 2、fanout exchange
 * 分发。有没有routing key都一样，消息分发到每个队列上
 *
 * 3、topic exchange
 * 主题交换机。
 * * 只匹配一个词
 * # 匹配一个或多个词
 *
 * 4、headers exchange
 * 实际很少使用
 *
 */