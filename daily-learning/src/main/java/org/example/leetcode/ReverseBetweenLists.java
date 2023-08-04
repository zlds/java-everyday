package org.example.leetcode;



/**
 * @author: hanchaowei
 * @date 2023/7/29
 * @description: 反转链表指定区间元素
 */

public class ReverseBetweenLists {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// 创建哨兵节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		// 找到反转区间的前一个节点
		for (int i = 1; i< m; i++) {
			pre = pre.next;
		}
		// 反转区间的第一个节点
		ListNode start = pre.next;
		// 当前要反转的节点
		ListNode then = start.next;

		// 开始反转
		for (int i = 0; i < n - m; i++) {
			// 将当前节点的下一个节点移动到区间开始位置
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		listNode.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;

		ReverseBetweenLists reverseBetweenLists = new ReverseBetweenLists();
		ListNode result = reverseBetweenLists.reverseBetween(listNode, 2, 4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
