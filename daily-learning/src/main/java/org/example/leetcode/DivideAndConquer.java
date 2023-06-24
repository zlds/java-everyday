package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/6/23
 * @description: 分治算法学习
 */

public class DivideAndConquer {


	/**
	 * 转换为大写字母
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		int len = str.length();

		if (len == 1) {
			return str.toUpperCase();
		}

		// 分解：将字符串从中间位置分成两半
		int mid = len / 2;
		String left = str.substring(0, mid);
		String right = str.substring(mid, len);

		// 解决: 递归将每一半的字母转换为大写
		String upperLeft = toUpperCase(left);
		String upperRight = toUpperCase(right);

		// 合并：将两个已转换为大写的半字符串合并成一个字符串
		return upperLeft + upperRight;

	}

	// 计算x的n次方

	public static double pow(int x, int n) {
		double result = 1.0;
		int absN = Math.abs(n);

		for (int i = 0; i < absN; i++) {
			// 每次循环乘以x
			result *= x;
		}
		return n < 0 ? 1 / result: result;
	}


	public static double pow1(double x, int n) {
		long N = n;

		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		return fastPow(x,N);
	}

	private static double fastPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		}
		return half * half * x;
	}


	public static void main(String[] args) {
		System.out.println("字母转换大写: " + toUpperCase("abcdefg"));

		System.out.println("暴力计算x的n次方: " + pow(2,10));

		System.out.println("分治计算x的n次方： " + pow1(2.0,10));


	}













}
