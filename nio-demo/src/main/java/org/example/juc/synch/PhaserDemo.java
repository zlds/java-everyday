package org.example.juc.synch;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/1/26
 * @description: 阶段器
 */

public class PhaserDemo {

	public static void main(String[] args) {
		Phaser phaser = new Phaser();
		// 假设5个参与者
		for (int i = 1; i <=5 ; i++) {
			// 注册各个参与者
			phaser.register();
			final int number = i;
			new Thread(() -> {
				System.out.println("参与者 " + number + "第一点阶段开始");
				// 等待其他参与者完成阶段1(假设第一段注册3个线程，必须等待其他线程)
				phaser.arriveAndAwaitAdvance();
				// 模拟一些工作
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				System.out.println("参与者 " + number + "第二阶段开始");
				// 等待其他参与者完成阶段2(比如第二阶段需要新增2个线程，2个线程执行phaser.register()注册)
				phaser.arriveAndAwaitAdvance();
				// 完成所有节点后注销
				phaser.arriveAndDeregister();
			}, "Thread " + i ).start();
		}
	}
}
