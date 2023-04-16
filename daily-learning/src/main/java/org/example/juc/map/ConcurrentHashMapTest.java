package org.example.juc.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hanchaowei
 * @date 2023/4/16
 * @description:
 */

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				concurrentHashMap.put("A", i);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				concurrentHashMap.put("B", i);
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(concurrentHashMap);

	}
}
