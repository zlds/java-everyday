package org.example.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author: hanchaowei
 * @date 2023/11/30
 * @description: 数据写入完整性校验
 */

public class DataWriteIntegrityChecker {

	public static String calculateChecksum(byte[] data, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		// 计算哈希值(哈希值本身也是字节序列)
		byte[] hashCode = digest.digest(data);
		// 将字节序列转换为十六进制字符串
		return bytesToHex(hashCode);
	}

	private static String bytesToHex(byte[] hashCode) {
		StringBuilder hexString = new StringBuilder();
		for (byte b : hashCode) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public static boolean writeToFileWithIntegrityCheck(String filePath, byte[] newData, String algorithm) throws IOException, NoSuchAlgorithmException {
		// 读取当前文件内容
		byte[] originalData = Files.exists(Paths.get(filePath)) ? Files.readAllBytes(Paths.get(filePath)) : new byte[0];

		// 计算合并后的数据哈希
		byte[] combinedData = Arrays.copyOf(originalData, originalData.length + newData.length);
		System.arraycopy(newData, 0, combinedData, originalData.length, newData.length);
		String initialHash = calculateChecksum(combinedData, algorithm);

		// 写入新数据
		try (FileOutputStream fos = new FileOutputStream(filePath, true)) {
			fos.write(newData);
		}

		// 验证写入后的文件哈希
		byte[] writtenData = Files.readAllBytes(Paths.get(filePath));
		String finalHash = calculateChecksum(writtenData, algorithm);

		if (!initialHash.equals(finalHash)) {
			// 哈希不匹配，恢复原始数据
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				fos.write(originalData);
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			String filePath = "file.txt";
			byte[] newData = "add hello".getBytes();

			// 写文件并检查完整性
			boolean isIntact = writeToFileWithIntegrityCheck(filePath, newData, "SHA-256");

			if (isIntact) {
				System.out.println("文件写入并验证成功");
			} else {
				System.out.println("文件写入并验证失败,恢复原始数据。");
			}
		} catch (IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
