package org.example.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: hanchaowei
 * @date 2023/12/2
 * @description:
 */

public class FileInputStreamTest {

	public static void main(String[] args) {
		// 源文件
		String sourceFile = "source.txt";
		// 目标文件
		String destinationFile = "destination.txt";
		// 使用try-with-resources语句，不在需要显式关闭资源。
		try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
				FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
			int byteRead;
			// 读取源文件并写入目标文件
			while ((byteRead = fileInputStream.read()) != -1) {
				fileOutputStream.write(byteRead);

			}
			System.out.println("文件复制完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
