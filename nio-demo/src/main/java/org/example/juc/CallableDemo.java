package org.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: hanchaowei
 * @date 2023/3/16
 * @description:
 */

public class CallableDemo implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(500);
		System.out.println("这是CallableDemo线程");
		return "CallableDemo线程";
	}

	public static void main(String[] args) {
		FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());

	}
}
