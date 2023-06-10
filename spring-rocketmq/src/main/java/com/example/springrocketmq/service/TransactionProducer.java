package com.example.springrocketmq.service;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author: hanchaowei
 * @date 2023/6/9
 * @description:
 */

public class TransactionProducer {
	public static void main(String[] args) throws Exception {
		// 创建事务型生产者
		TransactionMQProducer transactionProducer = new TransactionMQProducer("transaction-producer-group");
		transactionProducer.setNamesrvAddr("localhost:9876");
		transactionProducer.setTransactionListener(new TransactionListenerImpl());
		transactionProducer.start();

		// 发送消息
		Message message = new Message("transaction-topic","Hello RocketMQ".getBytes(StandardCharsets.UTF_8));

		try {
			TransactionSendResult transactionSendResult = transactionProducer.sendMessageInTransaction(message, null);
			System.out.println("Transaction id: " + transactionSendResult.getTransactionId());
			System.out.println("发送结果: " + transactionSendResult);
			if (transactionSendResult.getLocalTransactionState() == LocalTransactionState.ROLLBACK_MESSAGE) {
				System.out.println("发送失败");
			} else {
				System.out.println("发送成功");
			}
			transactionProducer.shutdown();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}
}
