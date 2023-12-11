package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/5
 * @description:
 */

public class ListNode {

	/**
	 * 节点值
	 */
	int value;

	/**
	 * 下一个节点的指针
	 */
	ListNode next;


	public ListNode(int value) {
		this.value = value;
	}

	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
}
