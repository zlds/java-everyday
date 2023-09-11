package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/5
 * @description: 最小花费爬楼梯
 */

public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		// 初始化
		int[] dp = new int[n];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < n; i++) {
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		}
		//
		return Math.min(dp[n - 1], dp[n - 2]);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
		int[] cost = {2, 5, 20};
		int i = minCostClimbingStairs.minCostClimbingStairs(cost);
		System.out.println(i);
	}
}
