package org.example.datastructure;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/7/13
 * @description: 快速查找链表方法(缓存)
 */

public class FirstFindLinked {

	Map<Integer, Node> cache = new HashMap<>();


	public void addTask(Node node) {
		// 添加节点到链表

		// 更新缓存
		cache.put(node.getVal(), node);
	}


	public Node getTask(Integer val) {
		// 从缓存中获取节点
		if (cache.containsKey(val)) {
			return cache.get(val);
		}

		// 缓存不存在，则遍历链表进行查询
		Node currentNode = null;
		while (currentNode != null) {
			if (currentNode.getVal() == val) {
				cache.put(val, currentNode);
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	/**
	 * 二分查找
	 * @param head
	 * @param target
	 * @return
	 */
	public Node binarySearch(Node head, int target) {
		Node start = head;
		Node end = null;

		while (head != end) {
			Node middleNode = getMiddleNode(head, end);
			if (middleNode.val == target) {
				return middleNode;
			} else if (middleNode.val > target) {
				end = middleNode;
			} else {
				head = middleNode.next;
			}
		}
		return null;
	}

	private Node getMiddleNode(Node start, Node end) {
		Node slow = start;
		Node fast = start;

		while (fast != end && fast.getNext() != end) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}

	public static void main(String[] args) {
		// 使用缓存
		FirstFindLinked firstFindLinked = new FirstFindLinked();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		firstFindLinked.addTask(node1);
		firstFindLinked.addTask(node2);
		Node task = firstFindLinked.getTask(2);
		System.out.println(task);

		// 使用二分查找
		Node node = firstFindLinked.binarySearch(node1, 2);
		System.out.println(node);
	}

}


@Data
class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
	}


}
