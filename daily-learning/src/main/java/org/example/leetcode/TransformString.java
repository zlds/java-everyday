package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/10
 * @description: 字符串变形
 */

public class TransformString {

	public String transform(String str,int n) {
		// 分割字符串
		String[] words = str.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = words.length - 1;  i >= 0; i--) {
			// 遍历每个单词中的每个字符并反转大小写
			for (char c: words[i].toCharArray()) {
				if (Character.isUpperCase(c)) {
					result.append(Character.toLowerCase(c));
				} else {
					result.append(Character.toUpperCase(c));
				}
			}
			// 在单词之间添加空格
			if (i != 0) {
				result.append(" ");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		TransformString transformString = new TransformString();
		System.out.println(transformString.transform("Hello World",0));
	}
}
