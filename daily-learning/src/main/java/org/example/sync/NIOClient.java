package org.example.sync;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author: hanchaowei
 * @date 2024/1/21
 * @description:
 */

public class NIOClient {

	public static void main(String[] args) throws IOException {
		// 打开一个SocketChannel
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("localhost", 18080));
		System.out.println("连接服务端成功....");
		// 发送请求
		String message = "Hello, NIO Server.";
		ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
		socketChannel.write(writeBuffer);
		System.out.println("发送请求成功....");
		// 读取响应结果
		ByteBuffer readBuffer = ByteBuffer.allocate(1024);
		int numBytesRead = socketChannel.read(readBuffer);
		if (numBytesRead > 0) {
			readBuffer.flip();
			byte[] data = new byte[numBytesRead];
			readBuffer.get(data);
			String receivedMessage = new String(data,StandardCharsets.UTF_8);
			System.out.println("收到响应: " + receivedMessage);
		}
		// 关闭连接
		socketChannel.close();
	}
}
