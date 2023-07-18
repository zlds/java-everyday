package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2023/7/18
 * @description:
 */

public class ListNode {
	class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}

	Node head;

	/**
	 * 新增操作
	 * @param val
	 */
	public void insert(int val) {
		// 新增节点
		Node newNode = new Node(val);
		// 如果头节点为空，放到头节点
		if (head == null) {
			head = newNode;
		} else {
			/**
			 * 如果头节点不为空遍历结点,将新节点添加到尾部。创建一个新的current引用指向头结点，遍历链表找到尾结点，这样就不会影响到原始的头节点。
			 * (current。如果不创建current，在循环中头结点变成了尾结点)
			 */
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	/**
	 * 删除操作
	 * @param val
	 */
	public void delete(int val) {
		if (head == null) {
			return;
		}
		if (head.val == val) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			// 如果下一个节点的值等于要删除的值，将下一个节点指向下下个节点
			if (current.next.val == val) {
				current.next = current.next.next;
				return;
			}
			// 循环中移动当前节点到下一个节点
			current = current.next;
		}
	}

	/**
	 * 更新操作
	 * @param oldVal
	 * @param newVal
	 */
	public void update(int oldVal, int newVal) {
		if (head == null) {
			return;
		}
		Node current = head;
		while (current != null) {
			if (current.val == oldVal) {
				current.val = newVal;
				return;
			}
			current = current.next;
		}
	}

	/**
	 * 查找是否存在
	 * @param val
	 * @return
	 */
	public boolean search(int val) {
		Node current = head;
		while (current != null) {
			if (current.val == val) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode();
		listNode.insert(1);
		listNode.insert(2);
		listNode.insert(3);
		System.out.println("查找节点3是否存在: " + listNode.search(3));
		listNode.insert(4);
		listNode.insert(5);
		System.out.println("删除节点3");
		listNode.delete(3);
		System.out.println("再次查找节点3是否存在: " + listNode.search(3));
		System.out.println("将节点5更新为6");
		listNode.update(5,6);
		System.out.println("检查6是否存在" + listNode.search(6));

	}












}
