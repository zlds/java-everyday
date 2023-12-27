package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/27
 * @description: 链表中倒数第k个节点
 */

public class FindKthToTail {

	public static ListNode findKthToTail(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		// 先将fast指针向前移动k步
		for (int i = 0; i < k; i++) {
			// 如果fast已经到达链表末尾，则返回null
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// 当fast到达链表末尾时，slow正好指向倒数第k个节点。
		return slow;
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
		ListNode kthToTail = findKthToTail(l1, 4);
		System.out.println(kthToTail.value);
	}
}
