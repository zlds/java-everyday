package org.example.limiting.algorithm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/3/20
 * @description: 漏桶算法
 */

public class LeakBucketLimiter {

	/**
	 * 桶的容量
	 */
	private int capacity;

	/**
	 * 每秒流出的速率
	 */
	private  int rate;

	/**
	 * 桶中当前的水量
	 */
	private AtomicInteger water = new AtomicInteger(0);

	/**
	 * 上一次漏水时间
	 */
	private  long lastLeakTime = System.currentTimeMillis();

	/**
	 * 线程锁
	 */
	private Lock lock;


	public LeakBucketLimiter(int capacity, int rate) {
		this.capacity = capacity;
		this.rate = rate;
		this.lastLeakTime = System.currentTimeMillis();
		this.lock = new ReentrantLock();
	}

	public boolean acquire() {
		// 判断是不是空桶,当前时间作为上一次漏水时间
		if (water.get() == 0) {
			lastLeakTime = System.currentTimeMillis();
			water.addAndGet(1);
			return capacity != 0;
		}

		//先执行漏水，计算剩余水量
		int waterLeft = water.get() - ((int) ((System.currentTimeMillis() - lastLeakTime) / 1000)) * rate;
		water.set(Math.max(0,waterLeft));
		//更新lastLeakTime
		lastLeakTime = System.currentTimeMillis();
		// 尝试加水
		if ((water.get() < capacity)) {
			water.addAndGet(1);
			return true;
		} else {
			return false;
		}
	}

}
