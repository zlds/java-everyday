package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2024/5/8
 * @description: 手动创建数组
 */

public class ManualCreateArrayExample {

	/**
	 * 数组
	 */
	private int[] array;

	/**
	 * 数组实际元素数量
	 */
	private int size;

	public ManualCreateArrayExample(int capacity) {
		this.array = new int[capacity];
		this.size = 0;
	}

	public void insert(int element, int index) {
		// 判断访问下标是否超出范围
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("超出数组实际元素范围！");
		}
		// 从右向左循环(最后一位开始移动)，将元素逐个向右挪1位
		for (int i = size -1; i >= index; i--) {
			array[i+1] = array[i];
		}
		// 腾出的位置放入新元素
		array[index] = element;
		size++;
	}

	public void output() {
		for (int i = 0; i < size; i++) {
			System.out.printf(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ManualCreateArrayExample manualCreateArrayExample = new ManualCreateArrayExample(10);
		manualCreateArrayExample.insert(3, 0);
		manualCreateArrayExample.insert(7, 1);
		manualCreateArrayExample.insert(9, 2);
		manualCreateArrayExample.insert(5, 3);
		manualCreateArrayExample.output();
		manualCreateArrayExample.insert(6, 1);
		manualCreateArrayExample.output();
	}
}
