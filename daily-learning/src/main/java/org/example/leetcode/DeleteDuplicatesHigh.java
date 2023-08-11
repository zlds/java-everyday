package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/11
 * @description: 删除有序链表中重复出现的元素，只保留出现一次的元素
 */

public class DeleteDuplicatesHigh {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// 指向当前要保留的节点
		ListNode prev = dummy;

		while (head != null) {
			// 如果当前节点和下一个节点相等，则跳过所有相同的值
			if (head.next != null && head.val == head.next.val) {
				// 在次循环判断是否连续有多个相同的值
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				// 跳过所有相同的值之后，指向下一个不同的值
				prev.next = head.next;
			} else {
				prev = prev.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		DeleteDuplicatesHigh deleteDuplicatesHigh = new DeleteDuplicatesHigh();
		ListNode result = deleteDuplicatesHigh.deleteDuplicates(l1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}


}
