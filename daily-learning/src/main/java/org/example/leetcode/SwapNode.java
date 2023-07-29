package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/7/29
 * @description: 两两交换链表中的节点
 */

public class SwapNode {

	public ListNode swapPairs(ListNode head) {
		// 新建一个哨兵节点
		ListNode dummy = new ListNode(0);
		// 将哨兵节点的next指向真实的头节点
		dummy.next = head;
		// 记录当前节点的前一个节点
		ListNode prevNode = dummy;

		while (head != null && head.next != null) {
			// 记录第一个节点值
			ListNode firstNode = head;
			// 记录第二个节点值
			ListNode secondNode = head.next;
			// 将哨兵节点的值指向第二个节点
			prevNode.next = secondNode;
			// 第一个节点指向第二个节点的下一个节点
			firstNode.next = secondNode.next;
			// 第二个节点指向第一个节点
			secondNode.next = firstNode;

			// 将当前节点指向第一个节点
			prevNode = firstNode;
			// 将head指向第一个节点的下一个节点
			head = firstNode.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		SwapNode swapNode = new SwapNode();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode result = swapNode.swapPairs(l1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
