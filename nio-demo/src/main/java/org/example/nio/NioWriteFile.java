package org.example.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: hanchaowei
 * @date 2023/3/19
 * @description:
 */

public class NioWriteFile {
	public static void main(String[] args) throws IOException {
		// 创建文件输出流
		FileOutputStream fileOutputStream = new FileOutputStream("/data/file/niotest.txt");
		// 获取通道
		FileChannel channel = fileOutputStream.getChannel();
		// 创建缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		// 向缓冲区写入数据
		byteBuffer.put("hello,word!".getBytes());
		// 移动指针到头部，否则数据为空
		byteBuffer.flip();
		// 将缓冲区的内容写到通道中
		channel.write(byteBuffer);
		fileOutputStream.close();
	}
}
