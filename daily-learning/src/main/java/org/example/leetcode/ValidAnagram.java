package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/6/20
 * @description: 有效的字母异位词。判断两个字符串是否是字母异位词
 */

public class ValidAnagram {

	public static boolean ifStrAnagram(String s1, String s2) {
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

	public static void main(String[] args) {
		// ture
		System.out.println("tar 和art 比较结果: "+ ifStrAnagram("tar", "art"));
		// false
		System.out.println("ta 和art 比较结果: "+ ifStrAnagram("ta", "art"));

	}
}
