package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/4/20
 * @description:
 */

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] ints = twoSum(nums, target);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
	// 暴力求和
	public static int[] twoSum(int[] nums,int target) {
		int length = nums.length;
		for (int i = 0; i < length - 1 ; i++) {
			for (int j = i +i ; j < length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// 更高效的查询方法
	public static int[] goodTowSum(int[] nums,int target) {
		int length = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		map.put(nums[0],0);
		for (int i = 1; i< length; i++) {
			// 先判断新元素是否满足条件
			int another = target - nums[i];
			if (map.containsKey(another)) {
				return new int[]{map.get(another),i};
			}
			map.put(nums[i],i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
}
