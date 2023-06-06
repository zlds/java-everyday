package com.example.springrocketmq.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/6/6
 * @description:
 */

public class RocketMQConsumer {

	public static void main(String[] args) throws Exception {
		// 创建一个名为 "consumer_group" 的消费者组
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");
		// 设置 NameServer 地址
		consumer.setNamesrvAddr("localhost:9876");
		// 订阅一个 Topic
		consumer.subscribe("topic-a", "*");
		// 注册消息监听器
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				for (MessageExt msg : msgs) {
					System.out.println("Receive message: " + new String(msg.getBody()));
				}
				// 确认消费
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 启动消费者
		consumer.start();
		System.out.println("Consumer started.");
	}
}
