package org.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author: hanchaowei
 * @date 2023/3/4
 * @description:
 */

public class NioDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 1.打开一个服务端通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 2.绑定对应的端口号
		serverSocketChannel.bind(new InetSocketAddress(9999));
		// 3.设置通道非阻塞
		serverSocketChannel.configureBlocking(false);
		System.out.println("服务端启动成功.....");
		while (true) {
			// 4.检查是否有客户端连接，有客户端连接返回对应的通道
			SocketChannel accept = serverSocketChannel.accept();
			if (accept == null) {
				System.out.println("没有客户端连接，我去做其他事情了...");
				Thread.sleep(1000);
				continue;
			}
			// 5.获取客户端传过来的数据，并把数据放在byteBuffer这个缓冲区中
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			// 返回值，正数表示读到有效字节数，0表示本次没有读到数据，-1表示末尾
			int read = accept.read(byteBuffer);
			System.out.println("客户端消息： " + new String(byteBuffer.array(),0,read, StandardCharsets.UTF_8));

			// 6.返回数据给客户端
			accept.write(ByteBuffer.wrap("没钱".getBytes(StandardCharsets.UTF_8)));
			accept.close();
		}
	}









}
