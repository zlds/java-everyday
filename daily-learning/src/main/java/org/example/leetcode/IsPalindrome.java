package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/17
 * @description: 回文数字
 */

public class IsPalindrome {

	/**
	 * 普通求解
	 * @param x
	 * @return
	 */
	public boolean isPalindrome1(int x) {
		// 缺点开辟新空间
		String s = String.valueOf(x);
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public boolean isPalindrome2(int x) {
		// 负数或0结尾的数字不是回文数字
		if (x < 0 || x != 0 && x % 10 == 0) {
			return false;
		}
		// 反转一半数字。存储数字的后半部分的反转值，然后将该反转值与前半部分进行比较
		int revertedNumber = 0;
		// x % 10 获取最后一位数字。如对于12345,结果是5。
		// revertedNumber * 10 + x % 10 将revertedNumber乘以10，然后加上x的最后一位数字
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			// x /= 10 去除x的最后一位数字
			x /= 10;
		}
		return x == revertedNumber || x == revertedNumber / 10;


	}

	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		boolean palindrome = isPalindrome.isPalindrome1(121);
		System.out.println(palindrome);
		boolean palindrome2 = isPalindrome.isPalindrome2(1221);
		System.out.println(palindrome2);
	}

}
