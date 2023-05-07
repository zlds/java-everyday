package org.example.thread.pool.threadexception;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description:
 */

public class MyRunnableTaskWithException implements Runnable {

	@Override
	public void run() {
		// 抛出一个异常
//		throw new RuntimeException("Runnable任务异常");
		try {
			// 抛出一个异常
			throw new Exception("Runnable任务异常");
		} catch (Exception e) {
			// 在run()方法内部捕获并处理异常
			System.out.println("Runnable任务内部捕获异常: " + e.getMessage());
		}
	}
}
