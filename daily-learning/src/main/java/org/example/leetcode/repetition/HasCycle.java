package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/31
 * @description: 判断链表是否有环(复习)
 */

public class HasCycle {

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 如果快慢指针相遇，则说明链表有环
			if (slow == fast) {
				return true;
			}
		}
		// 如果fast指针走到了链表末尾，则说明链表无环
		return false;
	}

	public static void main(String[] args) {
		// 判断是否有环
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l2;

		boolean hasCycle = new HasCycle().hasCycle(l1);
		System.out.println(hasCycle);

	}
}
