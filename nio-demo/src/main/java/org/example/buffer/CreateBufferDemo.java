package org.example.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author: hanchaowei
 * @date 2023/3/4
 * @description:
 */

public class CreateBufferDemo {
	public static void main(String[] args) {
		// 创建指定长度的buffer
		ByteBuffer byteBuffer = ByteBuffer.allocate(5);
		for (int i = 0; i < 5; i++) {
			System.out.println(byteBuffer.get());
		}

		// 创建由内容的buffer
		ByteBuffer byteBuffer1 = ByteBuffer.wrap("hello word".getBytes());
		for (int i = 0; i < 10; i++) {
			System.out.println(byteBuffer1.get());
		}
	}
}
