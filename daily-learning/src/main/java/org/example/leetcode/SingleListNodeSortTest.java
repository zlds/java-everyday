package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/10
 * @description: 单链表排序
 */

public class SingleListNodeSortTest {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 将链表一分为二
		ListNode middle = getMiddle(head);
		ListNode middleNext = middle.next;
		middle.next = null;
		// 递归对两部分别进行排序
		ListNode left = sortList(head);
		ListNode right = sortList(middleNext);
		// 合并两个已排序的部分
		return merge(left,right);
	}


	/**
	 * 获取中间节点
	 * @param head
	 * @return
	 */
	public ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * 合并两个已经排序列表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode merge(ListNode l1,ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		// 假设是排序过的
		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		SingleListNodeSortTest nodeSortTest = new SingleListNodeSortTest();
		ListNode result = nodeSortTest.sortList(l1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}
