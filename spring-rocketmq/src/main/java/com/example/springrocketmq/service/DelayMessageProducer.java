package com.example.springrocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author: hanchaowei
 * @date 2023/6/8
 * @description: 延迟消息学习
 */

public class DelayMessageProducer {


	public static void main(String[] args) throws Exception {
		DefaultMQProducer producer = new DefaultMQProducer("producer-group-delay");
		producer.setNamesrvAddr("localhost:9876");
		producer.start();

		int totalMessagesToSend = 100;
		for (int i = 0; i < totalMessagesToSend; i++) {
			// 创建消息
			Message message = new Message("delayTopic",("Hello scheduled message " + i).getBytes());
			/**
			 * 设置延迟等级3，这个消息将在10s之后发送.
			 * RocketMQ不支持任意的延迟时间，而是提供了固定18个等级，从1s到2h。
			 */
			message.setDelayTimeLevel(3);
			producer.send(message);
		}
		// 关闭生产者实例
		producer.shutdown();
	}
}
