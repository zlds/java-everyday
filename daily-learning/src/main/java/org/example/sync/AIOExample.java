package org.example.sync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CountDownLatch;

/**
 * @author: hanchaowei
 * @date 2024/1/23
 * @description: 异步IO示例
 */

public class AIOExample {

	public static void main(String[] args) throws IOException, InterruptedException {

		Path path = Paths.get("data.txt");
		AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// TODO 为了打印效果，增加CountDownLatch确保主线程退出前异步线程已经执行完成
		CountDownLatch latch = new CountDownLatch(1);

		// 异步读取数据
		fileChannel.read(buffer, 0, buffer,new CompletionHandler<Integer,ByteBuffer>() {
			// 读取完成后会回调completed方法
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				attachment.flip();
				byte[] data = new byte[attachment.limit()];
				attachment.get(data);
				System.out.println(new String(data));
				attachment.clear();
				latch.countDown();
			}
			// 读取失败后会回调failed方法
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				System.out.println("读取数据失败: " + exc);
				exc.printStackTrace();
				latch.countDown();
			}
		});
		// 等待异步操作完成
		latch.await();
	}
}
