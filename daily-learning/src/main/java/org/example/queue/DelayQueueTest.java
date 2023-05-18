package org.example.queue;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/5/18
 * @description:
 */

public class DelayQueueTest {

	// 延迟消息队列
	private static DelayQueue delayQueue = new DelayQueue();


	public static void main(String[] args) throws InterruptedException {
		producer();
		consumer();

	}

	// 生产者
	public static void producer() {
		// 添加消息
		delayQueue.put(new delayMessage(1000, "消息1"));
		delayQueue.put(new delayMessage(3000, "消息2"));
	}

	// 消费者
	public static void consumer() throws InterruptedException {
		System.out.println("开始执行时间： " + DateFormat.getDateInstance().format(new Date()));
		while (!delayQueue.isEmpty()) {
			System.out.println(delayQueue.take());
		}
		System.out.println("结束执行时间：" + DateFormat.getDateInstance().format(new Date()));
	}


	static class delayMessage implements Delayed {

		// 延迟截止时间(单位: 毫秒)
		long delayTime = System.currentTimeMillis();

		// 消息内容
		String message;

		public delayMessage(long delayTime, String message) {
			this.delayTime = delayTime + System.currentTimeMillis();
			this.message = message;
		}

		// 获取剩余时间
		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}

		// 队列里元素的排序依据
		@Override
		public int compareTo(Delayed o) {
			delayMessage delayMessage = (delayMessage) o;
			return this.delayTime > delayMessage.delayTime ? 1 : (this.delayTime < delayMessage.delayTime ? -1 : 0);
		}

		@Override
		public String toString() {
			return "delayMessage{" +
					"delayTime=" + delayTime +
					", message='" + message + '\'' +
					'}';
		}
	}


}
