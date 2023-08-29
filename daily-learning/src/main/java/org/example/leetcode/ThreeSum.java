package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/8/27
 * @description: 三数之和
 */

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}

		// 对数组进行排序
		Arrays.sort(nums);
		// 由于是3数之和，所以使用-2。
		for (int i = 0; i < nums.length - 2; i++) {
			// 跳过重复值。nums[i] == nums[i - 1] 是将当前值与上一个值进行对比，如果一样跳过.
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 固定一个数。如当前元素是2，那么我们需要找到另外两个元素相加等于-2的，这样就是2+-2=0.
			int target = -nums[i];
			// 左右指针
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == target) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					// 跳过重复值。避免出现重复的三元组
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum.threeSum(nums);
		System.out.println(lists);
	}
}
