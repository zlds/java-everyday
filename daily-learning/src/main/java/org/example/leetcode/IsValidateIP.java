package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/12
 * @description: 判断是否是有效的IP地址
 */

public class IsValidateIP {


	public String isValidateIP(String ip) {
		if (isValidateIpv4(ip)) {
			return "IPV4";
		}
		if (isValidateIpv6(ip)) {
			return "IPV6";
		}
		return "Neither";
	}


	private boolean isValidateIpv4(String ip) {
		String[] parts = ip.split("\\.", -1);
		if (parts.length != 4) {
			return false;
		}
		for (String part : parts) {
			if (part.length() == 0 || part.length() > 3) {
				return false;
			}
			if (part.charAt(0) == '0' && part.length() != 1) {
				return false;
			}
			for (char ch : part.toCharArray()) {
				if (!Character.isDigit(ch)) {
					return false;
				}
			}
			if (Integer.parseInt(part) > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidateIpv6(String ip) {
		// 以:分割,-1表示不会忽略任何空字符串
		String[] split = ip.split(":", -1);
		// 基本条件判断
		if (split.length != 8) {
			return false;
		}
		for (String s : split) {
			// 每一组的长度不能大于4
			if (s.length() == 0 || s.length() > 4) {
				return false;
			}
			// 没一位进行校验
			for (char c : s.toCharArray()) {
				boolean isDigit = Character.isDigit(c);
				boolean isUpperCaseAF = c >= 'A' && c <= 'F';
				boolean isLowerCaseAF = c >= 'a' && c <= 'f';
				if (!(isDigit || isUpperCaseAF || isLowerCaseAF)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsValidateIP isValidateIP = new IsValidateIP();
		System.out.println(isValidateIP.isValidateIP("172.16.254.1"));
		System.out.println(isValidateIP.isValidateIP("2001:0db8:85a3:0:0:8A2E:0370:7334"));
	}
}
