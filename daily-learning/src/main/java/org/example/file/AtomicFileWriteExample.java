package org.example.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author: hanchaowei
 * @date 2023/11/30
 * @description: 原子性地写入文件测试
 */

public class AtomicFileWriteExample {

	/**
	 * 原子性地写入文件
	 * @param file 目标文件
	 * @param data 要写入的数据
	 * @throws IOException
	 */
	public static void writeFileAtomically(File file, String data) throws IOException {
		File tempFile = new File(file.getAbsolutePath() + ".tmp");
		// 读取原有内容并追加新数据
		String existingData = file.exists() ? new String(Files.readAllBytes(file.toPath())) : "";
		String combinedData = existingData + data;
		// 写入临时文件
		Files.write(tempFile.toPath(), combinedData.getBytes());

		// 重命名临时文件为目标文件
		if (!tempFile.renameTo(file)) {
			throw new IOException("重命名临时文件到目标文件失败");
		}
	}


	public static void main(String[] args) {
		try {
			File targetFile = new File("data.txt");
			String data = "hello world\n";
			writeFileAtomically(targetFile, data);
			System.out.println("写入成功");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
