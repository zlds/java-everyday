package org.example.leetcode;


/**
 * @author: hanchaowei
 * @date 2023/7/30
 * @description: 删除有序链表中重复元素
 */

public class SkipDuplicates {

	public ListNode skipDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		// 新建哨兵节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;

		ListNode current = prev.next;

		while (current != null) {
			//  跳过所有重复的节点
			while (current.next != null && current.val == current.next.val) {
				// 如果当前节点和下一个节点的值相同，则移动current
				current = current.next;
			}
			// 检查current是否是重复序列的最后一个节点
			if (prev.next == current) {
				// 如果是，则移动prev
				prev = prev.next;
			} else {
				// 如果不是，则将prev的next指向current的next
				prev.next = current.next;
			}
			// 移动current
			current = current.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		SkipDuplicates skipDuplicates = new SkipDuplicates();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode result = skipDuplicates.skipDuplicates(l1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
