package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2023/7/11
 * @description: 数组实现队列
 */

public class ArrayQueue {

	/**
	 * 数组 items
	 */
	private String[] items;

	/**
	 * 数组大小
	 */
	private int n = 0;

	private int head = 0;
	private int tail = 0;

	/**
	 * 申请一个大小为 capacity 的数组
	 * @param capacity
	 */
	public ArrayQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}

	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean enqueue(String item) {
		// 如果tail == n表示队列已经满了
		if (tail == n) {
			// tail == n && head == 0 表示整个队列都占满了
			if (head == 0) {
				return false;
			}

			/**
			原始数据:
			0 1 2 3 4 5
				a b c
			搬移后:
			0 1 2 3 4 5
			a b c
			*/

			// 数据搬移
			for (int i = head; i < tail; i++) {
				items[i - head] = items[i];
			}
			// 搬移完之后重新更新head和tail
			tail -= head;
			head = 0;
		}
		items[tail] = item;
		++tail;
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
		++head;
		return ret;
	}


	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue("1");
		arrayQueue.enqueue("2");
		arrayQueue.enqueue("3");
		arrayQueue.enqueue("4");
		arrayQueue.enqueue("5");
		boolean enqueue = arrayQueue.enqueue("6");
		System.out.println(enqueue);
		System.out.println(arrayQueue.dequeue());
		System.out.println(arrayQueue.dequeue());
	}

	
}
