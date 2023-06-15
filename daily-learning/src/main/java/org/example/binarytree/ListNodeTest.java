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

	/**
	 * 在指定位置插入新的节点
	 * @param head
	 * @param index
	 * @param val
	 * @return
	 */
	public static ListNode insertAt(ListNode head, int index,int val) {
		// 虚拟头节点
		ListNode virtualHead = new ListNode(-1);
		// 将虚拟头结点的下一个节点执行实际的头节点
		virtualHead.next = head;

		// 当前节点
		ListNode curr = virtualHead;

		// 找出要插入位置的前一个节点。如1->2->3->4->5，要在2和3之间插入新节点，则找到2
		for (int i = 0; i < index; i++) {
			if (curr.next != null) {
				curr = curr.next;
			} else {
				throw new IllegalArgumentException("index out of bounds");
			}
		}
		// 创建新节点
		ListNode newNode = new ListNode(val);
		// 新节点的下一个节点指向当前节点的下一个节点
		newNode.next = curr.next;
		// 当前节点的下一个节点指向新节点
		curr.next = newNode;
		return virtualHead.next;
	}


	public static ListNode deleteAt(ListNode head, int index) {
		// 虚拟头结点
		ListNode virtualHead = new ListNode(-1);
		virtualHead.next = head;

		ListNode current = virtualHead;

		// 找到要删除节点的前一个节点
		for (int i = 0; i < index; i++) {
			if (current.next != null) {
				current = current.next;
			} else {
				throw new IllegalArgumentException("index out of bounds");
			}
		}

		// 删除节点
		if (current.next != null) {
			current.next = current.next.next;
		}
		return virtualHead.next;

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
		System.out.println("==============");
		int[] ints = {5,4,3,2,1};
		ListNode list = createList(ints);
		printList(list);

		// 测试在指定位置插入数据
		System.out.println("======= 在指定位置插入测试 =======");
		int[] arrInsert = {1,2,3,4,5};
		ListNode updateListNode = createList(arrInsert);
		ListNode insertResult = insertAt(updateListNode, 2, 100);
		printList(insertResult);


		// 测试在指定位置删除数据
		System.out.println("======= 在指定位置删除测试 =======");
		int[] arrDelete = {1,2,3,4,5};
		ListNode deleteListNode = createList(arrDelete);
		ListNode deleteResult = deleteAt(deleteListNode, 2);
		printList(deleteResult);
	}
}
