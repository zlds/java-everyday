package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/9
 * @description: 求平方根
 */

public class SqrtTest {

	public static double sqrt(int x, double precision) {
		double left = 0;
		double right = x;
		double ans = -1;


		while (right - left > precision) {
			double mid = (left + right) / 2;

			if (mid * mid < x) {
				left = mid;
				ans = mid;
			} else {
				right = mid;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		System.out.println(sqrt(5, 0.000001));
	}













}
