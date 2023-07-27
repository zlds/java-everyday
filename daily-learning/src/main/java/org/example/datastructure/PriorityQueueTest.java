package org.example.datastructure;

import java.util.PriorityQueue;

/**
 * @author: hanchaowei
 * @date 2023/7/27
 * @description: 优先队列
 */

public class PriorityQueueTest {



	public static void main(String[] args) {
		// 创建优先级队列
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// 添加元素
		priorityQueue.add(10);
		priorityQueue.add(15);
		priorityQueue.add(20);

		// 查看队首元素
		System.out.println(priorityQueue.peek());
		// 出队
		System.out.println(priorityQueue.poll());

		// 再次查看队首元素
		System.out.println(priorityQueue.peek());

	}
}
