package org.example.redisson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hanchaowei
 * @date 2023/4/9
 * @description:
 */

public class UserServiceTest {
	public static void main(String[] args) {
		UserService userService = new UserService();
		int numberOfThreads = 10;
		CountDownLatch latch = new CountDownLatch(numberOfThreads);
		for (int i = 0; i < numberOfThreads; i++) {
			new Thread(() -> {
				userService.updateUser();
				latch.countDown();
			}).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("所有线程已完成更新操作。");


//		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
//		for (int i = 0; i < numberOfThreads; i++) {
//			executorService.submit(() -> {
//				userService.updateUser();
//			});
//		}
	}
}
