package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/6/20
 * @description: 有效的字母异位词。判断两个字符串是否是字母异位词
 */

public class ValidAnagram {

	public static boolean isStrAnagram(String s1, String s2) {
		// 如果两个字符串长度不相等，直接返回false
		if (s1.length() != s2.length()) {
			return false;
		}

		// 两个字符串长度相等，创建一个数组，用于存储每个字符出现的次数
		int[] counter = new int[26];

		for (int i = 0; i < s1.length(); i++) {

			/**
			 * 这段代码的意思是：字符串a的ASCII码是97,字符串b的ASCII码是98，那么a-b的值就是1，然后将1的结果作为索引
			 * ++的意思是如果字符串a中有两个a，那么counter[0]的值就是2
			 * --的意思是如果字符串相同，就会减掉，如果字符串不同，就会加上。最终元素中的所有元素都应该是0，因为每个字符串出现的参数都相同
			 * 为什么是-a: 是为了将所有的小写字母转换为一个索引范围从0到25。'a' - 'a' = 0 ;直到'z' - 'a' = 25
			 */
			counter[s1.charAt(i) - 'a']++;
			counter[s2.charAt(i) - 'a']--;
		}

		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}

		return true;

	}


	/**
	 * 字母
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isAnagram1(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		// 转换成字符数组
		char[] charsA = s1.toCharArray();
		char[] charsB = s2.toCharArray();

		Arrays.sort(charsA);
		Arrays.sort(charsB);
		return Arrays.equals(charsA,charsB);
	}

	public static boolean isAnagram2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character,Integer> count = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char s = s1.charAt(i);
			char t = s2.charAt(i);
			count.put(s,count.getOrDefault(s,0) + 1);
			count.put(t,count.getOrDefault(t,0) - 1);
		}

		for (char c : count.keySet()) {
			if (count.get(c) != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// ture
		System.out.println("tar 和art 比较结果: "+ isStrAnagram("tar", "art"));
		// false
		System.out.println("ta 和art 比较结果: "+ isStrAnagram("ta", "art"));
		// true
		System.out.println(isAnagram1("tar", "art"));
		// true
		System.out.println(isAnagram2("tar","art"));

	}
}
