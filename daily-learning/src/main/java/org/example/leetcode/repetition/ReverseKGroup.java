package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2023/12/25
 * @description: K个一组反转链表
 */

public class ReverseKGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		int length = 0;
		// 计算链表长度
		while (head != null) {
			length++;
			head = head.next;
		}
		while (length >= k) {
			cur = pre.next;
			// 记住当前节点的下一个节点
			ListNode next = cur.next;
			for (int i = 1; i < k; i++) {
				// 保存当前节点的下一个节点
				cur.next = next.next;
				// 当前节点的下一个节点指向next的下一个节点
				next.next = pre.next;
				// pre的下一个节点指向next
				pre.next = next;
				// next的下一个节点指向cur
				next = cur.next;
			}
			// 将pre指向下一组的头节点
			pre = cur;
			length -= k;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		ListNode res = reverseKGroup(l1, 3);
		while (res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}
}
