package org.example.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/1/31
 * @description: 自定义线程工厂
 */

public class ThreadFactoryExample {

	public static void main(String[] args) {
		// 创建自定义的ThreadFactory
		ThreadFactory threadFactory = new ThreadFactory() {
			// 线程计数器
			private int count = 1;
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("custom-thread-" + count++);
				return thread;
			}
		};

		// 使用自定义的ThreadFactory创建线程池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				2,
				4,
				1000, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(),
				// 使用自定义的ThreadFactory设置线程名称等相关属性
				threadFactory
		);

		// 提交任务
		for (int i = 0; i < 5; i++) {
			executor.execute(() -> {
				System.out.println("任务执行中，线程名称为：" + Thread.currentThread().getName());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			});
		}

		// 关闭线程池
		executor.shutdown();
	}
}
