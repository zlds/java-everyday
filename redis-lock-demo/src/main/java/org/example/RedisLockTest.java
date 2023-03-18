package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

public class RedisLockTest {

	private int count = 0;

	private void call(Jedis jedis) {
		// 生成一个唯一id，标识自己
		String requestId = UUID.randomUUID().toString();
		boolean locked = RedisLock.tryLock(jedis, "lockKey", requestId, 60);
		try {
			if (locked) {
				for (int i = 0; i < 500; i++) {
					count++;
				}
			}
		} finally {
			RedisLock.unlock(jedis,"lockKey",requestId);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMinIdle(1);
		jedisPoolConfig.setMaxIdle(5);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,1000);

		RedisLockTest redisLockTest = new RedisLockTest();

		Thread t1 = new Thread(() -> redisLockTest.call(jedisPool.getResource()));
		Thread t2 = new Thread(() -> redisLockTest.call(jedisPool.getResource()));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(redisLockTest.count);


	}
}
