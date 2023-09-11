package org.example.leetcode;

import java.util.Arrays;

/**
 * @author: hanchaowei
 * @date 2023/9/11
 * @description: 最长公共子串
 */

public class LongestCommonSubstring {
	/**
	 * 暴力解法
	 * @param str
	 * @return
	 */
	public String s1(String[] str) {
		if (str == null || str.length == 0) {
			return "";
		}
		// 将第一个字符作为基准字符
		for (int i = 0; i < str[0].length(); i++) {
			char c = str[0].charAt(i);
			for (int j = 1; j < str.length; j++) {
				// 如果当前字符串长度等于i，或者字符不匹配，返回当前字符之前的字符串
				if (i == str[j].length() || str[j].charAt(i) != c) {
					return str[0].substring(0, i);
				}
			}
		}
		return str[0];
	}

	/**
	 * 排序后比较第一个和最后一个字符串
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// 对字符串数组进行排序
		Arrays.sort(strs);

		// 取排序后第一个和最后一个字符串，因为最长的公共前缀一定不超过第一个字符串
		String first = strs[0];
		String last = strs[strs.length - 1];

		int i = 0;
		// 比较这两个字符串，找到它们的公共前缀
		while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
			i++;
		}
		return first.substring(0, i);
	}

	public static void main(String[] args) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		String[] str = {"flower","flight","foo"};
		System.out.println(longestCommonSubstring.s1(str));
		String[] str1 = {"apple","appetite","app"};
		System.out.println(longestCommonSubstring.longestCommonPrefix(str1));
	}
}
