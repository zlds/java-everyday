package org.example.thread.pool;

import java.util.concurrent.Callable;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description:
 */

public class MyCallableTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(200);
		return "任务执行完成";
	}
}
