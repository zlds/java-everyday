package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/8
 * @description: 判断两个数字是否相等
 */

public class AreAdjacent {

	public boolean areAdjacent(int[] list, int num1, int num2) {
		// 记录要查找的位置
		int i1 = -1;
		int i2 = -1;

		for (int i = 0; i < list.length; i++) {
			if (list[i] == num1) {
				i1 = i;
			}
			if (list[i] == num2) {
				i2 = 1;
			}
			// 如果找到了就提前退出
			if (i1 != -1 && i2 != -1) {
				break;
			}
		}

		return Math.abs(i1 - i2) == 1;
	}
}
