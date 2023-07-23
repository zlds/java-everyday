package org.example.leetcode;

import java.util.Stack;

/**
 * @author: hanchaowei
 * @date 2023/7/23
 * @description: 最小值栈
 */

public class MinStack {

	/**
	 * 数据栈
	 */
	private Stack<Integer> dataStack;
	/**
	 * 最小值栈(辅助栈)
	 */
	private Stack<Integer> minStack;

	public MinStack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		dataStack.push(x);
		// 保证辅助栈栈顶一直是最小值
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int x = dataStack.pop();
		// 如果弹出的值是最小值，辅助栈也要弹出
		if (x == minStack.peek()) {
			minStack.pop();
		}
	}

	/**
	 * 获取栈顶元素
	 * @return
	 */
	public int top() {
		return dataStack.peek();
	}

	/**
	 * 获取最小值
	 * @return
	 */
	public int getMin() {
		return minStack.peek();
	}


	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(8);
		minStack.push(6);
		minStack.push(3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}
}
