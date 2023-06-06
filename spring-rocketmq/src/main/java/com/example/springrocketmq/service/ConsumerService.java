package com.example.springrocketmq.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/6/6
 * @description:
 */

@Service
@RocketMQMessageListener(topic = "test-topic",consumerGroup = "my-consumer-group")
public class ConsumerService implements RocketMQListener<String> {
	@Override
	public void onMessage(String message) {
		System.out.println("接收到消息：" + message);
	}
}
