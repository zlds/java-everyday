package org.example.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2023/4/15
 * @description:
 */

public class ReadWriteLockExample {
	/**
	 * 写锁： 只允许一个线程写
	 * 读锁： 允许多个线程读
	 * 读写锁互斥: 一个线程持有写锁时，其他线程不能获取读锁；一个线程持有写锁时，其他线程不能或写锁.
	 *
	 */
	private final Map<String,String> map = new HashMap<>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	/**
	 * 写数据
	 * @param key
	 * @param value
	 */
	public void put(String key,String value) {
		lock.writeLock().lock();
		try {
			System.out.println("开始写入数据: key=" + key + ", value=" + value);
			map.put(key,value);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public String get(String key) {
		lock.readLock().lock();
		try {
			System.out.println("开始读数据：key=" + key);
			return map.get(key);
		} finally {
			lock.readLock().lock();
		}
	}

	public static void main(String[] args) {
		ReadWriteLockExample example = new ReadWriteLockExample();
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 5; i++) {
			final int index = i;
			executorService.submit(() -> example.put("key" + index,"value" + index));
		}


		for (int i = 0; i < 5; i++) {
			final int index = i;
			executorService.submit(() -> System.out.println("读取key" + index + "的值为：" + example.get("key" + index)));
		}

		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
