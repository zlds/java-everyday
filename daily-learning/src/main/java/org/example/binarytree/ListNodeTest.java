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

	/**
	 * 使用数组创建链表
	 * @param arr
	 * @return
	 */
	public static ListNode createList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		// 头结点
		ListNode head = new ListNode(arr[0]);
		// 当前节点
		ListNode curr = head;
		// 遍历数组
		for (int i = 1; i < arr.length; i++) {
			// 创建新节点，值为当前元素
			curr.next = new ListNode(arr[i]);
			// 当前节点指向下一个节点
			curr = curr.next;
		}
		return head;
	}


	public static void main(String[] args) {
		// 创建链表 1->2->3->4->5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		printList(head);

		// 使用数组创建链表
		int[] ints = {5,4,3,2,1};
		ListNode list = createList(ints);
		System.out.println("==============");
		printList(list);
	}
}
