package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/13
 * @description: 寻找峰值
 */

public class PeakFinding {

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			// 如果nums[mid] < nums[mid + 1]，则说明峰值在右边，因为右边的元素比左边的元素大。否则在左边。
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		PeakFinding peakFinding = new PeakFinding();
		int[] example1 = {2, 4, 1, 2, 7, 8, 4};
		int[] example2 = {1, 2, 3, 1};
		// 可能输出1或5
		System.out.println("Example 1 Peak: " + peakFinding.findPeakElement(example1));
		// 输出2
		System.out.println("Example 2 Peak: " + peakFinding.findPeakElement(example2));
	}
}
