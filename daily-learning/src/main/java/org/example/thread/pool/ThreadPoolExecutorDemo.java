package org.example.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/1/29
 * @description:
 */

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		// 创建线程池
		int corePoolSize = 5;
		int maxPoolSize = 10;
		long keepAliveTime = 5000;

		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				corePoolSize,
				maxPoolSize,
				keepAliveTime,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(5)
				);

		// 模拟多个数据获取任务
		for (int i = 0; i < 10; i++) {
			int taskId = i;
			executor.execute(() -> fetchData(taskId));
		}
		// 关闭线程池
		executor.shutdown();
	}

	// 模拟数据获取处理方法
	private static void fetchData(int taskId) {
		System.out.println("任务Id " + taskId + ": 开始获取数据。线程名称 by " + Thread.currentThread().getName());
		// 模拟数据获取和处理的时间
		try {
			// 模拟耗时
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("任务Id " + taskId + ": 处理结束 by" + Thread.currentThread().getName());
	}

}
