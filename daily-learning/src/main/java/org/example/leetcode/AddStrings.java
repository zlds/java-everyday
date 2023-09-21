package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/16
 * @description: 字符串相加
 */

public class AddStrings {

	public String addString(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		StringBuffer result = new StringBuffer();
		while (i >= 0 || j >= 0 || carry > 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = x + y + carry;
			// 进位。如果大于10，进位为1
			carry = sum / 10;
			// 余数
			result.append(sum % 10);
			i--;
			j--;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		AddStrings test1 = new AddStrings();
		test1.addString("123", "459");
	}
}
