package org.example.datastructure;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/7/13
 * @description: 基于链表实现的栈
 */

public class StackBasedOnLinkedList {

	private Node top = null;


	public void push(int value) {
		Node newNode = new Node(value,null);
		// 判断是否空栈
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public int pop() {
		if (top == null) {
			return -1;
		}
		int value = top.val;
		top = top.next;
		return value;
	}

	public static void main(String[] args) {
		StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	@Data
	class Node {
		private int val;
		private Node next;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
}