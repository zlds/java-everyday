package org.example.leetcode;

import java.util.Arrays;

/**
 * @author: hanchaowei
 * @date 2023/9/24
 * @description: 寻找两个正序数组的中位数
 */

public class FindMedianSortedArrays {

	/**
	 * 暴力破解法
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] merged = new int[m + n];
		// 合并数组
		for (int i = 0; i < m; i++) {
			merged[i] = nums1[i];
		}
		for (int i = 0; i < n; i++) {
			merged[m + i] = nums2[i];
		}
		// 排序
		Arrays.sort(merged);
		// 奇数长度，如果是奇数，那么中位数就是郑中基的那个数。如如果数组长度是5，那么中为数的索引是2(5/2)
		if ((m + n) % 2 == 1) {
			return merged[(m + n) / 2];
		} else {
			// 偶数长度的情况。返回中间两个数字的平均值。如，数组长度是6，那么中间两个数字的索引分别是2(6/2-1)和3(6/2)，取这两个数字的平均值作为中位数
			return (merged[(m + n) / 2 - 1] + merged[(m + n) / 2]) / 2.0;
		}
	}

	public static void main(String[] args) {
		FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		double medianSortedArrays = findMedianSortedArrays.findMedianSortedArrays1(nums1, nums2);
		System.out.println(medianSortedArrays);
	}


}
