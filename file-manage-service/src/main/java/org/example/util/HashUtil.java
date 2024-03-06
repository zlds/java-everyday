package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: hanchaowei
 * @date 2024/3/6
 * @description: 文件哈希工具类
 */

public class HashUtil {

	/**
	 * 计算文件的MD5
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String md5(InputStream inputStream) throws IOException {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5算法不可用",e);
		}

		// 创建缓冲区
		byte[] buffer = new byte[1024];
		int read;

		try {
			// 读取输入流
			while ((read = inputStream.read(buffer)) != -1) {
				digest.update(buffer, 0, read);
			}
		} finally {
			inputStream.close();
		}
		// 完成哈希计算，得到md5
		byte[] md5sum = digest.digest();
		// 将结果转换为十六进制的字符串形式
		StringBuilder sb = new StringBuilder();
		for (byte b: md5sum) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}


	public static void main(String[] args) throws IOException {
		// 测试md5方法
		String md5 = md5(new FileInputStream("data.txt"));
		System.out.println(md5);
	}
}
