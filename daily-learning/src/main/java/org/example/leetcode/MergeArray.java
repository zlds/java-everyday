package org.example.leetcode;

import java.util.Arrays;

/**
 * @author: hanchaowei
 * @date 2024/5/19
 * @description: 合并数组
 */

public class MergeArray {

	/**
	 * 合并数组
	 * @param nums1
	 * @param m 数组有效值长度
	 * @param nums2
	 * @param n 数组有效值长度
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		// nums1有效元素尾指针
		int index1 = m - 1;
		// nums2有效元素末尾指针
		int index2 = n - 1;
		// 合并后数组的末尾指针
		int indexMerged = m + n - 1;

		// 从后往前合并两个数组
		while (index1 >= 0 && index2 >= 0) {
			if (nums1[index1] > nums2[index2]) {
				nums1[indexMerged] = nums1[index1];
				index1--;
			} else {
				nums1[indexMerged] = nums2[index2];
				index2--;
			}
			indexMerged--;
		}

		// 将nums2中剩余的元素复制到nums1中
		while (index2 >= 0) {
			nums1[indexMerged] = nums2[index2];
			index2--;
			indexMerged--;
		}
	}


	public static void main(String[] args) {
		int[] n1 = {1,3,5,0,0,0};
		int[] n2 = {2,4,6};
		merge(n1,3,n2,3);
		System.out.println(Arrays.toString(n1));
	}

}
