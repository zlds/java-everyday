package com.example.springrocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

/**
 * @author: hanchaowei
 * @date 2023/6/6
 * @description:
 */

public class RocketMQProducer {
	public static void main(String[] args) throws Exception {

		DefaultMQProducer producer = new DefaultMQProducer("producer-group-ack");
		producer.setNamesrvAddr("localhost:9876");
		producer.start();
		Message msg = new Message("topic-a","TagA",("hello").getBytes());
		// 发送消息并获取发送结果
		SendResult sendResult = producer.send(msg);
		// 判断消息是否发送成功
		if (sendResult.getSendStatus() != SendStatus.SEND_OK) {
			// 如果消息发送失败,处理失败逻辑(重试或者记录日志)
			System.out.println("消息发送失败" + sendResult);
		} else {
			System.out.println("消息发送成功" + sendResult);
		}
		// 关闭生产者
		producer.shutdown();
	}
}
