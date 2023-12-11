package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/11
 * @description: 反转链表
 */

public class ReverseListNode {

	public static ListNode reverseListNode(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			// 保存当前节点的下一个节点
			ListNode next = current.next;
			// 将当前节点的下一个节点指向前一个节点
			current.next = prev;
			// 将当前节点赋值给prev
			prev = current;
			// 将下一个节点赋值给current
			current = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode res = reverseListNode(l1);
		System.out.println(res.value);
	}
}
