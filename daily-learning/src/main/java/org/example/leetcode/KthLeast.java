package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author: hanchaowei
 * @date 2023/8/22
 * @description: 最小的k个数
 */

public class KthLeast {


	public int[] getLeastNumbers(int[] arr, int k) {

		if (arr == null || arr.length == 0 || k == 0) {
			return new int[0];
		}

		// 创建最大堆用来保存
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

		for (int num : arr) {
			// 如果堆的大小小于k，直接添加。否则判断当前元素是否小于堆顶元素，如果小于，移除堆顶元素，添加当前元素
			if (maxHeap.size() < k) {
				maxHeap.offer(num);
			} else if (num < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(num);
			}
		}

		// 创建结果
		int[] res = new int[maxHeap.size()];
		int index = 0;
		for (int num : maxHeap) {
			res[index++] = num;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{0, 1, 2, 1, 2};
		KthLeast kthLess = new KthLeast();
		int[] leastNumbers = kthLess.getLeastNumbers(arr, 3);
		for (int num : leastNumbers) {
			System.out.println(num);
		}
	}
}
