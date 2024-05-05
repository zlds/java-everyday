package org.example.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: 委托人执行任务。主线程接收请求，每个请求创建一个线程处理。
 */

public class ThreadPerMessageExample {

	public static void main(String[] args) throws IOException {
		// 监听本地8080端口
		final ServerSocketChannel ssc = ServerSocketChannel.open().bind(
				new InetSocketAddress(8080));

		// 处理请求
		try {
			while (true) {
				// 接收请求
				SocketChannel accept = ssc.accept();
				// 每个请求创建一个线程
				new Thread(() -> {
					// 读数据
					ByteBuffer rb = ByteBuffer.allocateDirect(1024);
					try {
						System.out.println("接收到请求" + accept.getRemoteAddress());
						accept.read(rb);
						// 模拟处理请求
						Thread.sleep(200);
						// 写数据
						ByteBuffer wb = (ByteBuffer) rb.flip();
						accept.write(wb);
						// 关闭
						accept.close();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).start();
			}
		} finally {
			ssc.close();
		}

	}
}
