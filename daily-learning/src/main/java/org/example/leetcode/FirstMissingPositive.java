package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/9
 * @description: 缺失的第一个正整数
 */

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; ++i) {
			// 将所有小于等于0的数变成n+1。因为我们只关心1到n的数。
			if (nums[i] <= 0) {
				nums[i] = n + 1;
			}
		}
		for (int i = 0; i < n; ++i) {
			int num = Math.abs(nums[i]);
			if (num <= n) {
				// 将出现过的数对应的位置的数变成负数
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}

		for (int i = 0; i < n; ++i) {
			// 返回第一个正数的位置,他的索引就是缺失的第一个正整数。
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		int[] nums = {1, 2, 0};
		int i = firstMissingPositive.firstMissingPositive(nums);
		System.out.println(i);
	}
}
