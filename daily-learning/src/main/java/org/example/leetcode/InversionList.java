package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/20
 * @description: 反转链表
 */

public class InversionList {

	public ListNode reverseList(ListNode head) {
		// 当前节点的上一个节点。由于是单链表，所以需要保存上一个节点，需要将当前节点的next指向它的前一个节点。
		ListNode prev = null;

		ListNode current = head;

		while (current != null) {
			// 保存下一个节点的值
			ListNode next = current.next;
			// 将当前节点的next指向上一个节点
			current.next = prev;
			// 将当前节点赋值给上一个节点
			prev = current;
			// 将下一个节点赋值给当前节点
			current = next;
		}
		return prev;
	}


	/**
	 * 打印链表
	 * @param head
	 */
	public static void printListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		InversionList inversionList = new InversionList();
		ListNode listNode1 = inversionList.new ListNode(1);
		ListNode listNode2 = inversionList.new ListNode(2);
		ListNode listNode3 = inversionList.new ListNode(3);
		ListNode listNode4 = inversionList.new ListNode(4);
		ListNode listNode5 = inversionList.new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		ListNode reverseListNode = inversionList.reverseList(listNode1);
		printListNode(reverseListNode);
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}


