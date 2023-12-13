package org.example.leetcode.repetition;


/**
 * @author: hanchaowei
 * @date 2023/12/13
 * @description: 合并两个有序链表
 */

public class MergeTwoListNode {


	 public static ListNode mergeList(ListNode l1, ListNode l2) {
		 ListNode dummy = new ListNode(0);
		 ListNode current = dummy;

		 while (l1 != null && l2 != null) {
			 if (l1.value < l2.value) {
				 current.next = l1;
				 l1 = l1.next;
			 } else {
				 current.next = l2;
				 l2 = l2.next;
			 }
			 current = current.next;
		 }

		 // 如果两个链表不相等,做拼接
		 if (l1 != null) {
			 current.next = l1;
		 } else {
			 current.next = l2;
		 }

		 return dummy.next;
	 }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(8);

		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		ListNode res = mergeList(l1, l5);
		while (res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}

}
