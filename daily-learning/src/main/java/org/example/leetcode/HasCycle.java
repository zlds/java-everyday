package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: hanchaowei
 * @date 2023/6/17
 * @description: 判断链表是否有环
 */

public class HasCycle {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.println(hasCycleSet(n1));
		System.out.println(hasCycle(n1));
	}



	public static Boolean hasCycleSet(ListNode head) {
		// 创建一个set集合，存放遍历过的节点
		Set<ListNode> nodeSet = new HashSet<>();

		// 遍历节点，如果节点出现在集合中返回ture；否则将节点添加到集合中
		while (head != null) {
			if (nodeSet.contains(head)) {
				return true;
			} else {
				nodeSet.add(head);
			}
			head = head.next;
		}
		return false;
	}

	/**
	 * 判断是否有环(快慢指针)
	 * @param head
	 * @return
	 */
	public static Boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			// 慢指针走一步
			slow = slow.next;
			// 快指针走两步
			fast = fast.next.next;
			// 如果相遇，说明有环
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
