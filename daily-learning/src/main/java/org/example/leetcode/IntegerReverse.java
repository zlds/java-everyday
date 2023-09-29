package org.example.leetcode;


/**
 * @author: hanchaowei
 * @date 2023/9/29
 * @description: 整数反转
 */

public class IntegerReverse {

	public int reverse(int n) {
		int result = 0;
		while (n != 0) {
			// 取最后一位。如x = 123,你们x % 10的结果是3
			int pop = n % 10;
			// 去掉最后一位。如x = 123,那么x / 10的结果是12
			n /= 10;
			
			// 检查溢出
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			result = result * 10 + pop;
		}
		return result;
	}

	public static void main(String[] args) {
	IntegerReverse integerReverse = new IntegerReverse();
		int reverse = integerReverse.reverse(123);
		System.out.println(reverse);
	}

}
