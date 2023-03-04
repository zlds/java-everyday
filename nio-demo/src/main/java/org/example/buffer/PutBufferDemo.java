package org.example.buffer;

import java.nio.ByteBuffer;

/**
 * @author: hanchaowei
 * @date 2023/3/4
 * @description:
 */

public class PutBufferDemo {
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);


		System.out.println("获取当前索引位置：" + byteBuffer.position());
		System.out.println("获取总长度：" + byteBuffer.capacity());
		// 写入数据
		byteBuffer.put((byte) 1);
		System.out.println("获取当前索引位置：" + byteBuffer.position());
		System.out.println("可用长度: " + byteBuffer.remaining());

		// 重新调整位置
		byteBuffer.position(0);
		System.out.println("重新调整之后可用长度: " + byteBuffer.remaining());

	}
}
