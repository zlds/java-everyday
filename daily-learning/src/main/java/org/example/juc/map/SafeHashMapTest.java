package org.example.juc.map;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/4/15
 * @description:
 */

public class SafeHashMapTest {
	public static void main(String[] args) throws InterruptedException {
		SafeHashMap<Integer,String> map = new SafeHashMap<>();
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 模拟并发写入
		for (int i = 0; i < 10; i++) {
			final int key = i;
			executorService.execute(() -> map.put(key,"Value" + key));
		}
		// 查询元素
		for (int i = 0; i < 10; i++) {
			final int key = i;
			executorService.execute(() -> System.out.println("key" + key + " value" + map.get(key)));
		}

		// 删除元素
		for (int i = 0; i < 10; i++) {
			final int key = i;
			executorService.execute(() -> map.remove(key));
		}
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("Final map size: " + map.size());
	}
}
