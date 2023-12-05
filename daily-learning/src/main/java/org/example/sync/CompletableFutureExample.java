package org.example.sync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: hanchaowei
 * @date 2023/12/5
 * @description: 异步编程
 */

public class CompletableFutureExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			// 模拟阻塞
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return printHello();
		});

		// 注册回调函数
		future.thenAccept(result -> System.out.println("result: " + result));

		// 阻塞并等待future完成
		System.out.println("等待future完成");
		System.out.println("Future result: " + future.get());
	}

	public static String printHello() {
		return "Hello";
	}
}
