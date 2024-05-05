package org.example.thread;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: 类比工厂模式有活大家一起干，没活聊聊天等待。无需频繁创建、销毁线程，提高性能。
 */

public class WorkerThreadExample {

	public static void main(String[] args) throws IOException {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 500, 60L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(2000), r -> {
			return new Thread(r, "echo-" + r.hashCode());
		});

		// 监听本地8080端口
		final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080));
		// 处理请求
		try {
			while (true) {
				// 接收请求
				SocketChannel sc = ssc.accept();
				// 将请求处理任务提交给线程池
				threadPoolExecutor.execute(() -> {
					try {
						// 读 Socket
						ByteBuffer rb = ByteBuffer.allocateDirect(1024);
						sc.read(rb);
						// 模拟处理请求
						Thread.sleep(200);
						// 写 Socket
						ByteBuffer wb = (ByteBuffer) rb.flip();
						sc.write(wb);
						// 关闭 Socket
						sc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		} finally {
			ssc.close();
			threadPoolExecutor.shutdown();
		}

	}
}
