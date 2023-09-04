package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/4
 * @description: 动态规划示例学习
 */

public class DynamicPlanning {


	/**
	 * 到上海的最小成本(北京到上海的成本)
	 * @param cost 其他城市路线的成本
	 * @param directCostBjToSH 直飞的成本
	 * @return
	 */
	public int minCostToShanghai(int[] cost, int directCostBjToSH) {
		// cost[0]是北京到苏州的成本,cost[1]是苏州到上海的成本。
		int n = cost.length;
		// 如果没有经过中间城市，直接返回直飞的成本
		if (n == 0) {
			return directCostBjToSH;
		}

		// 初始化,n+1是为了保存计算每个城市的总成本，包括起点和终点。
		int[] dp = new int[n + 1];

		// 北京的起始成本为0，因为我们已经在那里。
		dp[0] = 0;
		// 到苏州的成本
		dp[1] = cost[0];

		for (int i = 2; i <= n; i++) {
			// i-1是当前城市的索引，i-2是前一个城市的索引
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + directCostBjToSH);
		}
		return Math.min(dp[n], directCostBjToSH);
	}


	public static void main(String[] args) {
		// 北京到苏州100元，苏州到上海50元
		int[] cost = {100, 50};
		int directCostBJToSH = 200;
		DynamicPlanning dynamicPlanning = new DynamicPlanning();
		System.out.println(dynamicPlanning.minCostToShanghai(cost, directCostBJToSH));
	}
}
