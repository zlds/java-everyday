package org.example.binarytree;

/**
 * @author: hanchaowei
 * @date 2023/6/17
 * @description:
 */

public class DoublyListNodeTest {

	public static void main(String[] args) {
		DoublyListNode n1 = new DoublyListNode(1);
		DoublyListNode n2 = new DoublyListNode(2);
		DoublyListNode n3 = new DoublyListNode(3);
		DoublyListNode n4 = new DoublyListNode(4);
		// 设置每个节点的前驱和后继
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		System.out.println("------ 查找x节点 ------");
		DoublyListNode searchNode = search(n1, 3);
		System.out.println("前驱: " + searchNode.prev.val + " 后继: " + searchNode.next.val);

		System.out.println("------ 头插法 ------");

		DoublyListNode insertNode = insertHead(n1, 0);
		System.out.println("当前节点值: " + insertNode.val + " 后继: " + insertNode.next.val);


	}

	/**
	 * 查找
	 * @param head
	 * @param val
	 * @return
	 */
	public static DoublyListNode search(DoublyListNode head, int val) {
		DoublyListNode curr = head;
		while (curr != null && curr.val != val) {
			curr = curr.next;
		}
		return curr;
	}

	public static DoublyListNode insertHead(DoublyListNode head, int val) {
		// 创建新的节点
		DoublyListNode newNode = new DoublyListNode(0);
		// 设置新节点的后继
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		return newNode;
	}

	/**
	 * 删除节点
	 * 将前驱的后继指向后继，后继的前驱指向前驱
	 * @param node
	 */
	public static void deleteNode(DoublyListNode node) {
		// 如果删除的是头节点
		if (node.prev == null) {
			node.next.prev = null;
		} else {
			node.prev.next = node.next;
		}
		// 如果删除的是尾节点
		if (node.next == null) {
			node.prev.next = null;
		} else {
			node.next.prev = node.prev;
		}

	}
}
