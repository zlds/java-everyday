package org.example.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RAtomicLong;
import org.redisson.config.Config;

/**
 * @author: hanchaowei
 * @date 2023/4/9
 * @description:
 */

public class Counter {
	private final RedissonClient redissonClient;
	/**
	 * RAtomicLong是Redisson提供的原子性Long类型对象,可以跨多个进程，线程和服务器共享.
	 */
	private final RAtomicLong counter;

	public Counter() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		redissonClient = Redisson.create(config);
		counter = redissonClient.getAtomicLong("counter");
	}

	public void increment() {
		counter.incrementAndGet();
	}

	public long getValue() {
		return counter.get();
	}

	/**
	 * 关闭客户端
	 */
	public void close() {
		redissonClient.shutdown();
	}














}
