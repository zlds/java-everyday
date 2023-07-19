package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2023/7/19
 * @description: 双向链表
 */

public class DoubleLinkedList {
	class Node {
		private int val;
		private Node prev;
		private Node next;

		public Node(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public DoubleLinkedList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

	/**
	 * 新增操作
	 * @param val
	 */
	public void add(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			// 将新节点添加到尾部
			tail.next = newNode;
			// 新节点的prev指向原来的尾节点
			newNode.prev = tail;
		}
		// 当第一次添加节点的时候头节点和尾结点是一样的。如果是后续添加节点，更新尾节点为刚刚添加的新节点
		tail = newNode;
	}


	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList(null, null);
		doubleLinkedList.add(1);
		doubleLinkedList.add(2);
		doubleLinkedList.add(3);

	}
}
