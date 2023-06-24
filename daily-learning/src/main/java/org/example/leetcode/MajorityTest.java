package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/6/24
 * @description: 求众数
 */

public class MajorityTest {

	/**
	 * 暴力求解
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
		// 摩尔投票法
		int majorityCount = nums.length / 2;

		for (int num : nums) {
			int count = 0;
			for (int elem : nums) {
				if (elem == num) {
					count += 1;
				}
			}
			if (count > majorityCount) {
				return num;
			}
		}
		// 没有众数,返回-1
		return -1;
	}

	public static int majorityElementMap(int[] nums) {
		// 定义map存放元素和出现的次数
		Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
		// 定义众数出现的次数
		int majorityCount = nums.length / 2;

		for (int num : nums) {
			if (!counts.containsKey(num)) {
				counts.put(num,1);
			} else {
				counts.put(num,counts.get(num) + 1);
			}

			if (counts.get(num) > majorityCount) {
				return num;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] ints = {1, 3, 3, 2, 3,4};
		System.out.println("暴力求解: " + majorityElement(ints));
		System.out.println("map求解: " + majorityElementMap(ints));

	}













}
