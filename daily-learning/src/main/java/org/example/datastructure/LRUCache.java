package org.example.datastructure;

import java.util.HashMap;

/**
 * @author: hanchaowei
 * @date 2023/7/24
 * @description:
 */

public class LRUCache {

	class Node {
		int key;
		int value;
		Node prev;
		Node next;
	}

	private void addNode(Node node) {
		// 第一步，新节点的前后指针分别指向head和head.next
		node.prev = head;
		node.next = head.next;
		// 第二步，将head.next的前指针指向新节点
		head.next.prev = node;
		// 第三步，将head的后指针指向新节点
		head.next = node;
	}

	private void removeNode(Node node) {
		// 第一步，删除当前节点的前后指针
		Node prev = node.prev;
		Node next = node.next;
		// 第二步，将前后节点的指针指向彼此
		prev.next = next;
		next.prev = prev;

	}

	/**
	 * 将节点移动到头部(表示刚刚被访问过)
	 * @param node
	 */
	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	/**
	 * 移除尾部节点(表示这个节点是最近最少使用的)
	 * @return
	 */
	private Node popTail() {
		// 获取尾部节点的前一个数据节点
		Node res = tail.prev;
		removeNode(res);
		// 返回要删除的节点
		return res;
	}

	private HashMap<Integer, Node> cache = new HashMap<>();
	private int size;
	private int capacity;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;

		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if(node == null) {
			return -1;
		}

		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);

		if(node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			++size;

			if(size > capacity) {
				Node tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1,1);
		cache.put(2,2);
		System.out.println(cache.get(1));
		cache.put(3,3);
		System.out.println(cache.get(2));
		cache.put(4,4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
