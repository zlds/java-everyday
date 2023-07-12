package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2023/7/12
 * @description:
 */

public class CircularQueue {

	/**
	 * 数组items
	 */
	private String[] items;

	/**
	 * 数组大小
	 */
	private int n = 0;

	/**
	 * head表示队头下标
	 */
	private int head = 0;

	/**
	 * tail表示队尾下标
	 */
	private int tail = 0;


	/**
	 * 申请一个大小为n的数组
	 * @param capacity
	 */
	public CircularQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		// 判断队列是否满了
		if ((tail + 1) % n == head) {
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % n;
		return true;
	}

	/**
	 * 出队
	 * @return
	 */
	public String dequeue() {
		// 如果head == tail 表示队列为空
		if (head == tail) {
			return null;
		}
		String ret = items[head];
		head = (head + 1) % n;
		return ret;
	}


	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(5);
		circularQueue.enqueue("1");
		circularQueue.enqueue("2");
		circularQueue.enqueue("3");
		circularQueue.enqueue("4");
		circularQueue.enqueue("5");
		System.out.println(circularQueue.enqueue("6"));
		System.out.println(circularQueue.dequeue());
	}

}
