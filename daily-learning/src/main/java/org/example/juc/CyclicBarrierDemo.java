package org.example.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

public class CyclicBarrierDemo {
	// 模拟去旅游，当人数达到20个人时发车
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(20,() -> {
			System.out.println("====出发去三亚旅游......");
		});

		for (int i = 1; i <= 20; i++) {
			final int temp = i;
			new Thread(() -> {
				System.out.println("第几" + temp + "个人报名");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} catch (BrokenBarrierException e) {
					throw new RuntimeException(e);
				}
			},String.valueOf(i)).start();
		}
	}
}
