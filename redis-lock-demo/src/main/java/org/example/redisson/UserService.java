package org.example.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/4/9
 * @description:
 */

public class UserService {
	private final RedissonClient redissonClient;

	public UserService() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		this.redissonClient = Redisson.create(config);
	}

	public void updateUser() {
		// redis缓存中的key
		RLock lock = redissonClient.getLock("lock");
		try {
			lock.lock();
			// 执行业务操作
			try {
				System.out.println("执行更新操作......");
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		} finally {
			lock.unlock();
		}

	}
}
