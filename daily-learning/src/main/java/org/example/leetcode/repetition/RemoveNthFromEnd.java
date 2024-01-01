package org.example.leetcode.repetition;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/1/1
 * @description: 删除链表的倒数第N个节点
 */

public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		// 将快指针向移动n步
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		// 快慢指针同时移动，直到快指针到达链表末尾
		while (fast != null && fast.next != null) {
			slow = slow.next;
			// 快指针每次不需要以两倍速度移动。快指针的作用是提前移动n步，为我们定位到倒是第n个节点
			fast = fast.next;
		}
		// 删除节点
		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(l1, 2);
		while (listNode != null) {
			System.out.println(listNode.value);
			listNode = listNode.next;
		}
	}
}
