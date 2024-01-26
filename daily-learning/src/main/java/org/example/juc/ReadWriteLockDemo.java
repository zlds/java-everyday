package org.example.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

class Cache {
	private Map<String,Object> map = new HashMap<>();

	ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	// 模拟写操作
	public void put(String key,String val) {
		readWriteLock.writeLock().lock();
		try {
			System.out.println(key + "=====正在签字：" + val);
			TimeUnit.SECONDS.sleep(1);
			System.out.println(key + "=====签字完成");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	// 模拟读操作
	public Objects get(String key) {
		readWriteLock.readLock().lock();
		try {
			System.out.println(key + "=====正在读取");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			readWriteLock.readLock().unlock();
		}
		return null;
	}


}
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		Cache cache = new Cache();
		// 写
		for (int i = 1; i <=5; i++) {
			final String temp = String.valueOf(i);
			new Thread(() -> {
				cache.put(String.valueOf(temp),temp);
			},String.valueOf(i)).start();
		}
		// 读
		for (int i = 1; i <=5; i++) {
			final String temp = String.valueOf(i);
			new Thread(() -> {
				cache.get(String.valueOf(temp));
			},String.valueOf(i)).start();
		}
	}
}
