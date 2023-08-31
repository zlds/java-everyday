package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/31
 * @description: 跳台阶
 */

public class JumpStep {


	public int jumpFloor(int n) {
		// 基本情况
		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		// 递归。当选择跳1级，还有n-1级要跳;当选择跳2级，还有n-2级要跳
		return jumpFloor(n - 1) + jumpFloor(n - 2);

	}

	public static void main(String[] args) {
		JumpStep jumpStep = new JumpStep();
		System.out.println(jumpStep.jumpFloor(4));
	}

}
