package org.example.leetcode;


import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * @author: hanchaowei
 * @date 2023/8/23
 * @description: 表达式求值
 */

public class ExpressionEvaluation {

	public int calculate(String s) {

		if (StringUtils.isEmpty(s)) {
			return -1;
		}
		// 保存数字
		Stack<Integer> numStack = new Stack<>();
		// 保存运算符
		Stack<Character> opStack = new Stack<>();

		int num =0;
		// 用于保存当前的符号，1表示正，-1表示负
		int sign = 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				/**
				 * 对于多位数，挨个解析字符。如"123+45"、
				 * 当我读取到'1'时，并不能立即决定这是数字1，因为下一个字符是'2'依次类推。
				 * 读取字符 '1'，num = 0 * 10 + (1 - 0) = 1
				 * 读取字符 '2'，num = 1 * 10 + (2 - 0) = 12
				 * 读取字符 '3'，num = 12 * 10 + (3 - 0) = 123
				 * 这样就能成功地解析了数字123
				 */
				num = num * 10 + (c - '0');
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				// 如果遇到算术符号将num压入到数据栈中。并重置num;
				numStack.push(num);
				num = 0;
				while (!opStack.isEmpty() && (c == '+' || c == '-') && (opStack.peek() == '*' || opStack.peek() == '/')) {
					compute(numStack, opStack);
				}
				opStack.push(c);
			}

		}
		numStack.push(num * sign);
		while (!opStack.isEmpty()) {
			compute(numStack, opStack);
		}
		return numStack.pop();
	}

	private void compute(Stack<Integer> numbStack, Stack<Character> ops) {

		int b = numbStack.pop();
		int a = numbStack.pop();
		char op = ops.pop();

		int result;

		if (op == '+') {
			result = a + b;
		} else if (op == '-') {
			result = a - b;
		} else if (op == '*') {
			result = a * b;
		} else {
			result = a / b;
		}
		numbStack.push(result);
	}

	public static void main(String[] args) {
		ExpressionEvaluation cal = new ExpressionEvaluation();
		int res = cal.calculate("3*2+3");
		System.out.println(res);
	}
}
