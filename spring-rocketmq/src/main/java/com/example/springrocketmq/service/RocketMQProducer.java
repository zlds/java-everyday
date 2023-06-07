package com.example.springrocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;

import javax.annotation.Resource;

/**
 * @author: hanchaowei
 * @date 2023/6/6
 * @description:
 */

@Service
public class RocketMQProducer {
	@Resource
	private RocketMQTemplate rocketMQTemplate;

	public static void main(String[] args) throws Exception {

		DefaultMQProducer producer = new DefaultMQProducer("producer-group-ack");
		producer.setNamesrvAddr("localhost:9876");
		producer.start();
		Message msg = new Message("topic-a", "TagA", ("hello").getBytes());
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

	/**
	 * 同步发送消息
	 * @param message
	 * @return
	 */
	public String syncSend(String message) {
		String topic = "topic-sync";
		// 发送业务对象到指定topic
		SendResult sendResult = rocketMQTemplate.syncSend(topic,
				MessageBuilder.withPayload(new Order(System.currentTimeMillis(), 19.8))
						.setHeader(MessageHeaders.CONTENT_TYPE, MimeType.valueOf("application/json")));

		if (sendResult.getSendStatus() != SendStatus.SEND_OK) {
			System.out.println("消息发送失败" + sendResult);
			return "发送失败";
		} else {
			System.out.println("同步发送消息到" + topic + " 返回结果" + sendResult);
			return "发送成功";
		}
	}

	public String asyncSend(String message) {
		String topic = "topic-async";
		// 使用异步发送消息
		rocketMQTemplate.asyncSend(topic,
				MessageBuilder.withPayload(message).setHeader(RocketMQHeaders.KEYS, "KEY_" + System.currentTimeMillis())
						.build(), new SendCallback() {
					@Override
					public void onSuccess(SendResult sendResult) {
						System.out.println("异步发送成功: " + sendResult);
					}

					@Override
					public void onException(Throwable e) {
						System.out.println("异步发送失败: " + e.getMessage());
					}
				});
		return "发送成功";
	}
}
