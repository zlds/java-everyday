package org.example.redisson;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/4/9
 * @description: 通过Redisson实现区域编号递增
 */

public class RedissonLockDemo {
	private final RedissonClient redissonClient;


	public RedissonLockDemo() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		this.redissonClient = Redisson.create(config);
	}

	public void LockTime(String lockName) {
		// 获取锁
		RLock lock = redissonClient.getLock(lockName);
		try {
			lock.lock();
			// 获取当前值
			RAtomicLong atomicLong = redissonClient.getAtomicLong("regionId_" + lockName);
			System.out.println("成功获取锁，当前的值是: " + atomicLong.get());
			// 执行业务操作
			TimeUnit.SECONDS.sleep(1);
			// 更新缓存中的值
			atomicLong.incrementAndGet();
			System.out.println("更新之后的值是: " + atomicLong.get());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("释放锁");
			lock.unlock();
		}
	}

	/**
	 * 关闭客户端
	 */
	public void close() {
		redissonClient.shutdown();
	}

	public static void main(String[] args) {
		RedissonLockDemo redissonLockDemo = new RedissonLockDemo();
		int numOfThreads = 10;
		for (int i = 0; i < numOfThreads; i++) {
			new Thread(() -> {
				redissonLockDemo.LockTime("A");
			}).start();
		}

		try {
			TimeUnit.SECONDS.sleep(15);
			redissonLockDemo.close();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}
