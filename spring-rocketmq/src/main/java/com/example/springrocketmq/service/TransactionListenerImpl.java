package com.example.springrocketmq.service;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hanchaowei
 * @date 2023/6/9
 * @description:
 */

public class TransactionListenerImpl implements TransactionListener {

	/**
	 * 模拟保存本地事务的状态，实际应用中一般会使用数据库来存储事务状态
	 */
	private final ConcurrentHashMap<String,Integer> localTrans = new ConcurrentHashMap<>();

	/**
	 * 执行本地事务
	 * @param message 消息
	 * @param arg 自定义业务参数
	 * @return
	 */
	@Override
	public LocalTransactionState executeLocalTransaction(Message message, Object arg) {
		String transactionId = message.getTransactionId();
		System.out.println("执行本地事务id: " + transactionId);
		// 模拟数据库的操作
		int status = executeYourLocalTransaction();
		// 保存事务状态，这里假设0表示本地事务执行成功，1表示本地事务执行失败
		localTrans.put(transactionId,status);
		return status == 0 ? LocalTransactionState.COMMIT_MESSAGE : LocalTransactionState.ROLLBACK_MESSAGE;
	}

	/**
	 * 检查本地事务状态
	 * 该方法的作用是MQ服务器在一定时间(默认一分钟)内没有收到生产者的提交确认，会主动询问生产者本地事务的状态。
	 * @param messageExt
	 * @return
	 */
	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
		String transactionId = messageExt.getTransactionId();
		Integer status = localTrans.get(transactionId);
		System.out.println("检查本地事务id: " + transactionId + ",的状态: " + status);
		if (null != status) {
			switch (status) {
				case 0:
					return LocalTransactionState.COMMIT_MESSAGE;
				case 1:
					return LocalTransactionState.COMMIT_MESSAGE;
			}
		}
		return LocalTransactionState.UNKNOW;
	}

	private int executeYourLocalTransaction() {
		// 这里应执行你的本地事务，比如写入数据库等等
		// 为了演示，我们使用随机数来模拟本地事务的执行是否成功
		return Math.random() > 0.5 ? 0 : 1;
	}
}
