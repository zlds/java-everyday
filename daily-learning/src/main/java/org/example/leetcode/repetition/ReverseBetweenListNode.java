package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/14
 * @description: 反转指定区间的链表
 */

public class ReverseBetweenListNode {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		// 找到m的前一个节点
		for (int i = 0; i < m - 1; i++) {
			pre = pre.next;
		}
		// m节点开始
		ListNode current = pre.next;

		ListNode next;

		// 开始反转
		for (int i = 0; i < n - m; i++) {
			// 保存当前节点的下一个节点
			next = current.next;
			// 当前节点的下一个节点指向next的下一个节点
			current.next = next.next;
			// next的下一个节点指向pre的下一个节点
			next.next = pre.next;
			// pre的下一个节点指向next
			pre.next = next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode res = reverseBetween(l1, 2, 3);
		while (res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}
}
