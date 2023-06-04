package org.example.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: hanchaowei
 * @date 2023/6/4
 * @description: 密码校验
 */

public class PasswordChecker {

	/**
	 * 检查用户密码是否正确
	 * @param userId 用户ID
	 * @param plaintextPassword 用户提供的明文密码
	 * @param hashedPassword 数据库存储的哈希密码
	 * @return 密码是否正确
	 */
	public static boolean checkPassword(String userId,String plaintextPassword,
			String hashedPassword) {

		// 将用户ID当作盐值
		String plaintextWithSlat = plaintextPassword + userId;
		// 生成密码哈希值
		String hashedPlaintextWithSalt = sha256(plaintextWithSlat);
		return hashedPassword.equals(hashedPlaintextWithSalt);
	}


	/**
	 * 使用SHA-256哈希函数生成哈希值
	 * @param text 需要生成哈希值的文本
	 * @return 生成的哈希值
	 */
	private static String sha256(String text) {
		MessageDigest digest;
		try {
			// 获取SHA-256哈希函数
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256 not supported",e);
		}
		// 生成哈希值
		byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		// 将哈希值转换为十六进制字符串
		return bytesToHex(hash);
	}

	/**
	 * 将字节数据转换为十六进制字符串
	 * @param bytes 需要转换的字节数据
	 * @return 转换后的十六进制字符串
	 */
	private static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
		for (byte b: bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
