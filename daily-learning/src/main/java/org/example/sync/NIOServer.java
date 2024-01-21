package org.example.sync;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author: hanchaowei
 * @date 2024/1/21
 * @description: NIO 服务端示例
 */

public class NIOServer {
	public static void main(String[] args) throws IOException {
		// 创建ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress(18080));
		// 设置为非阻塞模式
		serverSocketChannel.configureBlocking(false);
		// 创建Selector,并将serverSocketChannel注册到上面
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("启动服务,等待连接........");

		while (true) {
			// 阻塞直到有事件发生
			selector.select();
			// 获取事件
			Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
			// 处理事件
			while (keyIterator.hasNext()) {
				SelectionKey next = keyIterator.next();
				// 处理连接事件
				keyIterator.remove();
				// 处理读事件
				if (next.isAcceptable()) {
					// 接受新的连接
					ServerSocketChannel server = (ServerSocketChannel) next.channel();
					SocketChannel client = server.accept();
					System.out.println("客户端连接来了...." + client);
					client.configureBlocking(false);
					// 将客户端注册到selector上
					client.register(selector, SelectionKey.OP_READ);
				} else if (next.isReadable()) {
					// 读取数据
					SocketChannel client = (SocketChannel) next.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					int len = client.read(buffer);
					if (len > 0) {
						buffer.flip();
						String receivedStr = StandardCharsets.UTF_8.decode(buffer).toString();
						System.out.println("收到数据: " + receivedStr);
						buffer.rewind();
						// 原封不动的写回去
						client.write(buffer);
					} else if (len == -1) {
						// 客户端断开连接
						System.out.println("客户端断开连接");
						client.close();
					}
				}
			}
		}
	}

}
