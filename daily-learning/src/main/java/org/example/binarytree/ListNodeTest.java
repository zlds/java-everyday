package org.example.binarytree;

/**
 * @author: hanchaowei
 * @date 2023/6/14
 * @description:
 */

public class ListNodeTest {

	/**
	 * 打印链表
	 * @param head
	 */
	public static void printList(ListNode head) {
		// 头指针
		ListNode curr = head;
		// 当前节点不为空，继续遍历
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}


	public static void main(String[] args) {
		// 创建链表 1->2->3->4->5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		printList(head);
	}
}
