package org.example.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hanchaowei
 * @date 2024/5/14
 * @description: Disruptor示例
 */

public class DisruptorExample {


	public static void main(String[] args) throws InterruptedException {
		// 配置和启动Disruptor
		ExecutorService executor = Executors.newCachedThreadPool();
		TradeTransactionFactory factory = new TradeTransactionFactory();
		// 这必须是2的幂
		int bufferSize = 1024;

		Disruptor<TradeTransaction> disruptor = new Disruptor<>(
				factory,
				bufferSize,
				executor,
				ProducerType.SINGLE,
				new YieldingWaitStrategy());
		TradeTransactionHandler handler = new TradeTransactionHandler();
		disruptor.handleEventsWith(handler);
		disruptor.start();
		// 发布事件
		RingBuffer<TradeTransaction> ringBuffer = disruptor.getRingBuffer();
		// 为了演示简单，这里只是模拟数据
		ByteBuffer bb = ByteBuffer.allocate(8);
		for (long i = 0; i < 100; i++) {
			// 清除缓冲区，准备写入
			bb.clear();
			// 在缓冲区的开始位置存入一个double值
			bb.putDouble(0, (double) i);
			ringBuffer.publishEvent((event, sequence, buffer) -> event.setPrice(buffer.getDouble(0)), bb);
			Thread.sleep(200);
		}
		disruptor.shutdown();
		executor.shutdown();
	}

}
