package org.example.leetcode.repetition;

import java.util.PriorityQueue;

/**
 * @author: hanchaowei
 * @date 2023/12/28
 * @description: 合并K个排序链表
 */

public class MergeKListNode {


	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length
				, (o1, o2) -> o1.value - o2.value);

		// 将每个链表的第一个节点添加到最小堆中
		for (ListNode node : lists) {
			if (node != null) {
				priorityQueue.add(node);
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!priorityQueue.isEmpty()) {
			// 取出最小元素并添加到结果链表的尾部
			tail.next = priorityQueue.poll();
			// 更新尾部
			tail = tail.next;
			/**
			 * 判断当前节点是否有下一个节点，如果有则将下一个节点添加到最小堆中。
			 * (因为每个节点是独立的，上面的for循环只是将每个链表的第一个节点添加到最小堆)
			 */
			if (tail.next != null) {
				priorityQueue.add(tail.next);
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(2);
		ListNode x3 = new ListNode(3);

		x1.next = x2;
		x2.next = x3;

		ListNode y1 = new ListNode(4);
		ListNode y2 = new ListNode(5);
		ListNode y3 = new ListNode(6);
		y1.next = y2;
		y2.next = y3;

		ListNode[] listNodes = {x1, y1};

		MergeKListNode mergeKListNode = new MergeKListNode();
		ListNode listNode = mergeKListNode.mergeKLists(listNodes);
		while (listNode != null) {
			System.out.println(listNode.value);
			listNode = listNode.next;
		}
	}
}
