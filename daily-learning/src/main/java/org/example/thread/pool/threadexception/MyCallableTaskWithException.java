package org.example.thread.pool.threadexception;

import java.util.concurrent.Callable;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description:
 */

public class MyCallableTaskWithException implements Callable<String> {

	@Override
	public String call() throws Exception {
		// 抛出一个异常
		throw new Exception("Callable任务异常");
	}
}
