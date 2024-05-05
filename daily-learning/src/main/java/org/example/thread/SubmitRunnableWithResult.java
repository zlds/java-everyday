package org.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: 提交Runnable任务并返回固定值(状态标识，标识一个任务完成)
 */

public class SubmitRunnableWithResult {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		// 提交无返回值的Runnable任务，并设置一个固定值"DONE"作为返回结果
		Future<String> future = executorService.submit(() -> {
			// 模拟一个数据清理任务
			System.out.println("执行数据清理任务");
		}, "DONE");
		// 检查任务是否已经完成
		try {
			String result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
		// 关闭线程池
		executorService.shutdown();
	}
}
