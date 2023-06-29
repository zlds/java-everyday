package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/6/29
 * @description: 生成有效括号组合
 */

public class GenerateParenthesisTest {

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate(n,n,"",result);
		return result;
	}

	public static void generate(int left, int right, String s,List<String> result) {
		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			generate(left - 1, right, s + "(", result);
		}

		if (right > left) {
			generate(left, right - 1,s + ")", result);
		}
	}

	public static void main(String[] args) {
		List<String> strings = generateParenthesis(2);
		System.out.println(strings);
	}
}
