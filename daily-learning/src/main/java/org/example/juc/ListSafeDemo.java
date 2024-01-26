package org.example.juc;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description: 线程安全的集合
 */

public class ListSafeDemo {
	public static void main(String[] args) throws InterruptedException {
		// 安全的集合
//		setList();
		setDemo();
	}

	private static void setList() throws InterruptedException {
		List<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,8));
			}).start();
		}
		TimeUnit.SECONDS.sleep(2);
		System.out.println(list);
	}

	public static void setDemo() {
		// 安全的集合
		Set<String> list = new CopyOnWriteArraySet<>();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,8));
			}).start();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(list);
	}
}
