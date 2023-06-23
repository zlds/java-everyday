package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/6/23
 * @description: 递归计算阶乘
 */

public class FactorialTest {

	public static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
