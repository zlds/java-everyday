package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/6/14
 * @description: 链表节点
 */

public class ListNode {

	/**
	 * 节点值
	 */
	int val;

	/**
	 * 下一个节点的指针
	 */
	ListNode next;

	/**
	 * 构造函数
	 * @param x
	 */
	ListNode(int x) {
		val = x;
	}

	/**
	 * 构造函数
	 * @param val
	 * @param next
	 */
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
