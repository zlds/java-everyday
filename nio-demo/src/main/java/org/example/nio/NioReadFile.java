package org.example.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: hanchaowei
 * @date 2023/3/19
 * @description:
 */

public class NioReadFile {
	public static void main(String[] args) throws IOException {
		// 打开文件
		File file = new File("/data/file/niotest.txt");
		// 创建输入流
		FileInputStream fileInputStream = new FileInputStream(file);
		FileChannel channel = fileInputStream.getChannel();
		// 创建缓冲区,所有的数据读写都是通过缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
		// 将通道中的数据读取到缓冲区
		channel.read(byteBuffer);
		System.out.println(new String(byteBuffer.array()));
		fileInputStream.close();
	}
}
