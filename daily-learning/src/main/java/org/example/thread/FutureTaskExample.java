package org.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: hanchaowei
 * @date 2024/5/4
 * @description:
 */

public class FutureTaskExample {


//	public static void main(String[] args) {
//		// 创建Callable任务
//		Callable<Integer> callable = () -> {
//			int result = 0;
//			for (int i = 0; i < 100; i++) {
//				result += i;
//			}
//			return result;
//		};
//
//		// 创建FutureTask
//		FutureTask<Integer> futureTask = new FutureTask<>(callable);
//
//		// 创建并启动新线程
//		Thread thread = new Thread(futureTask);
//		thread.start();
//
//		// 获取计算结果
//		try {
//			Integer result = futureTask.get();
//			System.out.println(result);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}





	/**
	 * 烧水泡茶程序。用两个线程t1和t2来完成，t1负责洗水壶、烧开水、泡茶，t2负责洗茶壶、洗茶杯、拿茶叶。
	 * 其中t1在执行过程中需要等待t2完成才能继续执行。
	 */
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 创建t2任务
		FutureTask<String> ft2 = new FutureTask<>(new T2Task());
		// 创建t1任务
		FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

		// 创建线程
		Thread t1 = new Thread(ft1);
		t1.start();
		Thread t2 = new Thread(ft2);
		t2.start();
		System.out.println(ft1.get());


	}
}
