package org.example.algorithm;

/**
 * @author: hanchaowei
 * @date 2023/5/30
 * @description:
 */

public class BinarySearchTest {

	public static int binarySearch(int[] arr, int target) {
		// 低指针
		int low = 0;
		// 高指针
		int high = arr.length - 1;

		while (low <= high) {
			// 计算中间值
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// 如果找不到目标元素，返回-1
		return -1;
	}


	public static void main(String[] args) {
		int[] arrys = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(binarySearch(arrys, 6));
	}
}
