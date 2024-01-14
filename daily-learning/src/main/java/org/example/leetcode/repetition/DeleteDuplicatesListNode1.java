package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2024/1/14
 * @description: 删除排序链表中的重复元素-I
 */

public class DeleteDuplicatesListNode1 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			// 判断当前节点的值是否和下一个节点值一样，如果一样则跳过
			if (current.value == current.next.value) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		DeleteDuplicatesListNode1 deleteDuplicatesListNode1 = new DeleteDuplicatesListNode1();
		ListNode listNode = deleteDuplicatesListNode1.deleteDuplicates(l1);
		while (listNode != null) {
			System.out.println(listNode.value);
			listNode = listNode.next;
		}
	}

}
