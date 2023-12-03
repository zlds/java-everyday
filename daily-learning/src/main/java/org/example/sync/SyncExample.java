package org.example.sync;


import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/12/3
 * @description:
 */

public class SyncExample {
	public static void main(String[] args) {
		System.out.println("任务1 开始执行: " + new Date());
		// 同步执行任务
		performTask();
		System.out.println("任务1 执行结束: " + new Date());
		System.out.println("任务2 开始执行: " + new Date());
		// 同步执行任务
		performTask();
		System.out.println("任务2 执行结束: " + new Date());
		System.out.println("任务3 开始执行: " + new Date());
		// 同步执行任务
		performTask();
		System.out.println("任务3 执行结束: " + new Date());
	}

	public static void performTask() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
