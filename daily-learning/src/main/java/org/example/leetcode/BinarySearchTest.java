package org.example.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/7/8
 * @description: 二分查找
 */

public class BinarySearchTest {

	public static int binarySearch(List<Integer> list,int target) {
		// 左边界
		int left = 0;
		// 右边界
		int right = list.size() -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (list.get(mid) == target) {
				return mid;
			} else if (list.get(mid) < target) {
				// target在右边
				left = mid + 1;
			} else {
				// target在左边
				right = right + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(Arrays.asList(1,2,3,4,5,6,7,8,9), 5));
	}
}
