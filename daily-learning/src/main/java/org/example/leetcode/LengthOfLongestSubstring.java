package org.example.leetcode;

import java.util.HashSet;

/**
 * @author: hanchaowei
 * @date 2023/9/21
 * @description: 无重复字符的最长子串
 */

public class LengthOfLongestSubstring {



	public int lengthOfLongestSubstring(String s) {
		// 创建哈希集合，记录每个字符是否出现过
		HashSet<Character> set = new HashSet<>();
		int n = s.length();
		// ans为最长子串的长度，i为左指针，j为右指针.
		int ans = 0;
		int i = 0;
		int j = 0;

		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				/**
				 * 移动左指针。目的是需要移除重复字符之前的所有字符，以便开始寻找一个新的，不包含重复字符的子串。
				 * 如输入"pwwkew" 当处理到第3个字符串(第二个'w')时，我们已经有一个子串"pw",这是一个包含重复字符的子串。
				 * 但是当我们到第二个"w"的时候，我们知道"pww"是一个包含重复的子串。所以我们不能使用这个子串，为了找到一个新的子串，需要从当前子串中移除重复字符之前的所有字符。
				 * 需要从"pww"中移除p，得到新的子串"ww"。然后，我们再次移除重复的'w'，得到子串"w"，现在，我们可以继续处理后面的字符，寻找一个更长的、不包含重复字符的子串
				 */
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
		System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
	}
}
