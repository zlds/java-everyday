package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author: hanchaowei
 * @date 2023/6/18
 * @description: 实时判断数据流中第k的最大值
 */

public class KthLargest {
	/*通过最小堆来解决。最小堆是一种特殊的树形数据结构，每个父节点的值都小于或等于其所有子节点的值。*/

	/**
	 * 创建最小堆
	 */
	private PriorityQueue<Integer> queue;
	/**
	 * k个大小元素
	 */
	private int k;


	public KthLargest(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<>(k);
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		// 如果队列大小小于k直接添加元素
		if (queue.size() < k) {
			queue.offer(val);
		}
		// 如果顶部元素小于val，弹出顶部元素，添加val。
		else if (queue.peek() < val) {
			queue.poll();
			queue.offer(val);
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		int k = 3;
		int[] num = new int[]{4, 5, 8, 2};
		KthLargest kthLargest = new KthLargest(k, num);
		// 输出 4
		System.out.println(kthLargest.add(3));
		// 输出 5
		System.out.println(kthLargest.add(5));
		// 输出 5
		System.out.println(kthLargest.add(10));
		// 输出 8
		System.out.println(kthLargest.add(9));
		// 输出 8
		System.out.println(kthLargest.add(4));
	}


}
