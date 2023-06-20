package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: hanchaowei
 * @date 2023/6/18
 * @description:
 */

public class StringIsValid {


	/**
	 * 判断括号字符串是否有效
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		// 循环遍历
		for (char c : s.toCharArray()) {
			// 如果是左括号压入栈中。如果是右括号先检查栈是否为空，并查看栈顶的元素是不是对应的开括号，如果是弹出
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() || stack.peek() == '(') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() || stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() || stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}


	public static void main(String[] args) {
		String s = "([]){}";
		System.out.println(isValid(s));
	}

}
