package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/29
 * @description: 删除有序链表中重复元素
 */

public class DeleteDuplicates {

	/**
	 * 删除有序链表中重复元素
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			// 如果当前节点值和下一个节点值相等则删除当前节点
			if (current.val == current.next.val) {
				current.next = current.next.next;
				// 这里并没有更新current，是因为我们需要判断current.next和当前的current是否相等。
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
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

		DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
		ListNode result = deleteDuplicates.deleteDuplicates(l1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}


}
