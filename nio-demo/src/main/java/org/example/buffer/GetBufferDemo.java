package org.example.buffer;

import java.nio.ByteBuffer;

/**
 * @author: hanchaowei
 * @date 2023/3/4
 * @description:
 */

public class GetBufferDemo {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		byteBuffer.put("1234".getBytes());
		System.out.println("获取当前位置: "+ byteBuffer.position());
		System.out.println("剩余: " + byteBuffer.remaining());
		// 读取数据为空，因为当前position是4，没有数据，需要切换读模式
		byte b = byteBuffer.get();
		System.out.println("读取到的数据" + b);
		// 切换读模式获取数据
		byteBuffer.flip();
		System.out.println("获取切换之后的当前位置: "+ byteBuffer.position());
		for (int i = 0; i < byteBuffer.limit(); i++) {
			System.out.println(byteBuffer.get());
		}

		// 读取指定索引字节
		System.out.println(byteBuffer.get(1));
	}
}
