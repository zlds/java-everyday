package org.example.juc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2023/4/15
 * @description: 通过ReadLock和WriteLock实现线程安全的HashMap
 */

public class SafeHashMap<K, V> {
	private final Map<K, V> map;
	private final ReadWriteLock lock;

	private final Lock readLock;

	private final Lock writeLock;

	public SafeHashMap() {
		map = new HashMap<>();
		lock = new ReentrantReadWriteLock();
		readLock = lock.readLock();
		writeLock = lock.writeLock();
	}

	public V get(K key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public V put(K key, V value) {
		writeLock.lock();
		try {
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public int size() {
		readLock.lock();
		try {
			return map.size();
		} finally {
			readLock.unlock();
		}
	}

	public boolean containsKey(K key) {
		readLock.lock();
		try {
			return map.containsKey(key);
		} finally {
			readLock.unlock();
		}
	}

	public V remove(K key) {
		writeLock.lock();
		try {
			return map.remove(key);
		} finally {
			writeLock.unlock();
		}
	}
}
