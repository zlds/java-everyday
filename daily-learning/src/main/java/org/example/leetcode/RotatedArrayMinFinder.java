package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/13
 * @description: 旋转数组的最小数字
 */

public class RotatedArrayMinFinder {

	public int search(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		// 左边界
		int left = 0;
		// 右边界
		int right = nums.length - 1;

		while (left < right) {
			// 中间值
			int mid = left + (right - left) / 2;
			// 中间值大于右边值，最小值在右侧。否则在左侧
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				right--;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		RotatedArrayMinFinder rotatedArrayMinFinder = new RotatedArrayMinFinder();
		int[] nums = {3,4,5,1,2};
		System.out.println(rotatedArrayMinFinder.search(nums));
		int[] nums1 = {3,100,200,2};
		System.out.println(rotatedArrayMinFinder.search(nums1));
	}
}
