package org.example.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: hanchaowei
 * @date 2023/3/16
 * @description: 计数器限流
 */
public class CounterLimiter {

	/**
	 * 开始时间
	 */
	private static long startTime = System.currentTimeMillis();
	/**
	 * 间隔时间
	 */
	private static long interval = 1000;
	/**
	 * 每秒限制的数量
	 */
	private static long limit = 2;
	/**
	 * 累加器
	 */
	private static AtomicLong accumulator = new AtomicLong(0);

	private static long tryAcquire(long taskId,int turn) {
		long nowTime = System.currentTimeMillis();
		if (nowTime < startTime + interval) {
			long count = accumulator.incrementAndGet();
			if (count <= limit) {
				return count;
			} else {
				return -count;
			}
		} else {
			synchronized (CounterLimiter.class) {
				// 再一次判断，防止重复初始化
				if (nowTime > startTime + interval)
				{
					accumulator.set(0);
					startTime = nowTime;
				}
			}
			return 0;
		}
	}
}
