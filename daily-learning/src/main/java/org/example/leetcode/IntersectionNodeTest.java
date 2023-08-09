package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/9
 * @description: 两个链表的第一个公共节点
 */

public class IntersectionNodeTest {



	public ListNode getIntersectionNode(ListNode n1, ListNode n2) {
		if (n1 == null || n2 == null) {
			return null;
		}

		/**
		 * 计算两个链表长度，将长度设置一致。
		 * 如果长度不一样，一个长，一个短，从两个链表的头部同时开始遍历，那么短链表先遍历完，
		 * 并且在长链表的指针未到达交点，短链表就遍历完了这样就找不到交点。
		 */
		int n1Length = getLength(n1);
		int n2Length = getLength(n2);

		while (n1Length > n2Length) {
			n1 = n1.next;
			n1Length--;
		}
		while (n2Length > n1Length) {
			n2 = n2.next;
			n2Length--;
		}
		int i = 1;
		while (n1 != null && n2 != null) {
			if (n1 == n2) {
				return n1;
			}
			n1 = n1.next;
			n2 = n2.next;
			i++;
		}
		return null;
	}

	/**
	 * 获取链表长度
	 * @param head
	 * @return
	 */
	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}


	public static void main(String[] args) {
		ListNode c1 = new ListNode(11);
		ListNode c2 = new ListNode(13);
		c1.next = c2;

		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(7);
		ListNode a5 = new ListNode(9);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = c1;

		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(9);
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;

		IntersectionNodeTest intersectionNodeTest = new IntersectionNodeTest();
		ListNode result = intersectionNodeTest.getIntersectionNode(a1, b1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}
