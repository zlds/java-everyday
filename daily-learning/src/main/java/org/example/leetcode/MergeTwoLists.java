package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/29
 * @description: 合并两个有序链表
 */

public class MergeTwoLists {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 新建一个哨兵节点
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 !=null) {
			if (l1.val < l2.val) {
				// 将哨兵节点的下一个节点，指向l1
				current.next = l1;
				// 更新l1的指针
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		// 如果两个链表长度不一致，剩余部分链接到最后
		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode l1 = mergeTwoLists.new ListNode(1);
		ListNode l2 = mergeTwoLists.new ListNode(3);
		ListNode l3 = mergeTwoLists.new ListNode(5);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = mergeTwoLists.new ListNode(2);
		ListNode l5 = mergeTwoLists.new ListNode(4);
		ListNode l6 = mergeTwoLists.new ListNode(6);
		l4.next = l5;
		l5.next = l6;

		ListNode result = mergeTwoLists.mergeTwoLists(l1, l4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
