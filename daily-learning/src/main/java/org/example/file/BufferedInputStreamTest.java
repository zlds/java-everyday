package org.example.file;

import java.io.*;

/**
 * @author: hanchaowei
 * @date 2023/12/2
 * @description:
 */

public class BufferedInputStreamTest {

	public static void main(String[] args) {
		// 源文件
		String sourceFile = "source.txt";
		// 目标文件
		String destinationFile = "destination.txt";
		// 使用try-with-resources语句，不在需要显式关闭资源。
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile,true))) {
			// 设置缓冲区大小为1024字节
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer,0,bytesRead);
			}
			System.out.println("文件复制完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
