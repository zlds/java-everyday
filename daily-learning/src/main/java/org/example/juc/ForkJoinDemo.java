package org.example.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author: hanchaowei
 * @date 2024/1/26
 * @description:
 */

public class ForkJoinDemo extends RecursiveTask<Integer> {

	private final int threshold = 5;
	private int start;
	private int end;

	public ForkJoinDemo(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;

		if ((end - start) <= threshold) {
			// 小任务直接计算
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 大任务分解成两个小任务。
			int middle = (start + end) / 2;
			ForkJoinDemo leftTask = new ForkJoinDemo(start, middle);
			ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1,end);
			leftTask.fork();
			rightTask.fork();
			sum = leftTask.join() + rightTask.join();
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinDemo task = new ForkJoinDemo(1,100);
		int result = forkJoinPool.invoke(task);
		System.out.println("Result: " + result);
	}
}
