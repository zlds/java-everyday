package org.example.leetcode;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/8/29
 * @description: 字符串排列
 */

public class StringPermutations {

	/**
	 * 字符串排列
	 * @param s
	 * @return
	 */
	public List<String> permutation(String s) {
		List<String> res = new ArrayList<>();
		if (StringUtils.isEmpty(s)) {
			return res;
		}
		// 转换成字符串，并对字符串进行排序
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		// 递归方法
		backtrack(chars,new boolean[chars.length],new StringBuilder(),res);
		return res;
	}


	/**
	 * 回溯算法
	 * @param chars
	 * @param used 表示当前字符否使用过，长度为chars.length。如果当前字符使用过，就不再使用
	 * @param current 当前的字符串
	 * @param res
	 */
	public void  backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> res) {

		// 递归终止条件
		if (current.length() == chars.length) {
			res.add(current.toString());
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			// 判断当前字符是否被使用过
			if (used[i]) {
				continue;
			}
			// 跳过重复的字符
			if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			current.append(chars[i]);
			backtrack(chars, used, current, res);
			// 撤销之前的选择，然后回溯选择一个新的方向(类似于走进了一个死胡同，得回到上一个路口)
			current.deleteCharAt(current.length() - 1);
			used[i] = false;
		}

	}

	public static void main(String[] args) {
		StringPermutations stringPermutations = new StringPermutations();
		String s = "abc";
		List<String> res = stringPermutations.permutation(s);
		System.out.println(res);
	}
}
