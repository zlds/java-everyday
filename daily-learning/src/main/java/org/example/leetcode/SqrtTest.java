package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/9
 * @description: 求平方根
 */

public class SqrtTest {


	/**
	 * 求平方根(指定精度)
	 * @param x
	 * @param precision 精度
	 * @return
	 */
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

	/**
	 * 求平方根
	 * @param x
	 * @return
	 */
	public  static int sqrt(int x) {

		if (x == 0 || x == 1) {
			return x;
		}

		int l = 1, r = x, res = -1;

		// 只要左边界不大于右边界，就继续查找
		while (l <= r) {
			// 计算中间值
			int mid = l + (r - l) / 2;
			// 如果中间值的平方等于x，直接返回
			if (mid == x / mid) {
				return mid;
			}
			// 如果中间值的平方大于x，说明中间值在左边，将右边界移动到mid-1。否则将左边界移动到mid+1
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
				// 将m的结果保存到res中，因为最后一次mid平方小于x的时候，m可能是最接近x的数
				res = mid;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(5, 0.01));
		System.out.println(sqrt(8));
	}













}
