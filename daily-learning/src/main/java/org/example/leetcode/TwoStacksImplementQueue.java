package org.example.leetcode;

import java.util.Stack;

/**
 * @author: hanchaowei
 * @date 2023/8/21
 * @description: 用两个栈实现队列
 */

public class TwoStacksImplementQueue {
	// 入队列
	Stack<Integer> stack1;
	// 出队列
	Stack<Integer> stack2;

	public TwoStacksImplementQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		// 如果stack2为空,则将stack1的元素转移到stack2
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		// 如果stack2仍然为空(原始队列为空),则返回-1
		if (stack2.isEmpty()) {
			return -1;
		} else {
			return stack2.pop();
		}
	}

	public static void main(String[] args) {
		TwoStacksImplementQueue cQueue = new TwoStacksImplementQueue();
		cQueue.appendTail(3);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());

	}
}
