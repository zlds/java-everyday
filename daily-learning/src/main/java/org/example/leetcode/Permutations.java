package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/8/28
 * @description: 全排列
 */

public class Permutations {


	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<>();

		if (num.length == 0) {
			return res;
		}
		backtrack(num,new ArrayList<>(),res);
		return res;
	}


	public void backtrack(int[] num, List<Integer> current, List<List<Integer>> res) {

		// 递归终止条件
		if (current.size() == num.length) {
			res.add(new ArrayList<>(current));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			// 如果当前值在current中，跳过
			if (current.contains(num[i])) {
				continue;
			}
			current.add(num[i]);
			backtrack(num, current, res);
			// 回溯,移除最后一个元素,这样在下一次循环中才能添加新的元素，保证元素的唯一性
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		int[] num = {1,2,3};
		List<List<Integer>> res = permutations.permute(num);
		System.out.println(res);
	}
}
