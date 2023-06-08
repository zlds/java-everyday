package com.example.springrocketmq.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/6/8
 * @description:
 */

public class DelayMessageConsumer {

	public static void main(String[] args) throws Exception {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group-delay");
		consumer.setNamesrvAddr("localhost:9876");
		consumer.subscribe("delayTopic", "*");
		// 注册回调实现类来处理从broker拉取回来的消息

		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
					ConsumeConcurrentlyContext consumeConcurrentlyContext) {
				for (MessageExt messageExt : list) {
					System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), new String(messageExt.getBody()));
				}
				// 标记该消息已经被成功消费
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
		System.out.printf("Consumer Started.%n");
	}
}
