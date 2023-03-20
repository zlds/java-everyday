package org.example.limiting.algorithm;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author: hanchaowei
 * @date 2023/3/20
 * @description: 限流计数器
 * 思路：
 * 	先检查时间戳是否在一秒内，如果是，检查计数器是否达到限流阈值，如果未达到返回ture，否则返回false。
 * 	如果时间戳不在一秒内，重置计数器，返回true。
 */

public class CounterLimiter {

	/**
	 * 每秒最大请求数
	 */
	private int maxLimit = 5;

	/**
	 * 开始时间
	 */
	private long startTime = System.currentTimeMillis();

	/**
	 * 时间区间
	 */
	private static long interval = 1000;

	/**
	 *  计数器
	 */
	private static AtomicInteger counter = new AtomicInteger(0);

	/**
	 * 计数判断，是否超过限制
	 */
	public boolean  tryAcquire() {
		long now = System.currentTimeMillis();
		// 判断请求是否在1秒之内。
		if (now - startTime < interval) {
			long count = counter.get();
			// 判断计数器是否超过最大限制
			if (count < maxLimit) {
				// 增加计数器
				counter.incrementAndGet();
				return true;
			} else {
				// 超过最大限制
				return false;
			}
		} else {
			// 重置计数器
			counter.set(0);
			startTime = now;
			return true;
		}
	}
}
