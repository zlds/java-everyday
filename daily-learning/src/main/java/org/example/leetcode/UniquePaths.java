package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/10
 * @description: 不同路径
 */

public class UniquePaths {

	public int uniquePathsWithObstacles(int[][] nums) {
		int length = nums.length;
		int[] res = new int[nums.length];
		res[0] = 1;

		for (int i = 0; i < nums[0].length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				// 遇到障碍物，设置0
				if (nums[i][j] == 1) {
					res[j] = 0;
				} else if (j > 0) {
					// 不是障碍物，且不是第一列，设置为上一列的值
					res[j] += res[j - 1];
				}
			}
		}
		return res[length - 1];
	}
}
