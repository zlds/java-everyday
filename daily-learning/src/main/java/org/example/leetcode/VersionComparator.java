package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/13
 * @description:
 */

public class VersionComparator {


	public static int compareVersion(String version1, String version2) {
		// 使用.来拆分版本号
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int maxLength = Math.max(v1.length, v2.length);

		for (int i = 0; i < maxLength; i++) {
			int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
			int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
			// 比较修订号
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		// 如果所有修订号都相同，则两个版本号相同。
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("1.0.1和1对比结果: " + compareVersion("1.0.1", "1"));
		System.out.println("1.0和1.0.0对比结果: " + compareVersion("1.0","1.0.0"));
		System.out.println("0.1和1.1对比的结果: " + compareVersion("0.1","1.1"));
	}
}
