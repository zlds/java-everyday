package org.example.binarytree;

/**
 * @author: hanchaowei
 * @date 2023/6/17
 * @description: 双向链表节点
 */

public class DoublyListNode {
	int val;
	/**
	 * 前驱
	 */
	DoublyListNode prev;
	/**
	 * 后继
	 */
	DoublyListNode next;

	public DoublyListNode(int val) {
		this.val = val;
	}
}
