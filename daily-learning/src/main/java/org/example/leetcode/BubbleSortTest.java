package org.example.leetcode;

import java.util.Arrays;

/**
 * @author: hanchaowei
 * @date 2023/7/18
 * @description: 冒泡排序
 */

public class BubbleSortTest {

	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{5,8,6,3,9,2,1,7};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
