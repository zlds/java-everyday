package org.example.thread;

/**
 * @author: hanchaowei
 * @date 2024/5/6
 * @description: 线程终止示例。
 * 通过中断的方式终止线程，而不是使用stop。
 */

public class ThreadStopExample {
	// 终止标志位
	private volatile boolean terminated = false;
	private boolean started = false;

	// 采集线程
	private Thread rptThread;
	// 启动采集线程
	synchronized void start() {
		// 不允许同时启动多个采集线程
		if (started) {
			return;
		}
		started = true;
		terminated = false;
		rptThread = new Thread(() -> {
			// 收到中断信号后会退出线程
			while (!terminated) {
				// 省略采集回传实现
				System.out.println("采集、回传线程");
				// 通过try-catch捕获中断异常来实现线程终止后的资源释放等操作
				try {
					// 每隔两秒采集、回传一次数据。
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("线程中断");
					// 在休眠状态时检测到中断，抛出异常(然后中断状态会被复位)，所以需要设置中断标志位为true
					Thread.currentThread().interrupt();
				}
			}
			//  终止线程
			started = false;
		});
		rptThread.start();
	}

	synchronized void stop() {
		// 设置中断标志位
		terminated = true;
		// 发送中断信号
		rptThread.interrupt();
	}

	public static void main(String[] args) {
		ThreadStopExample threadStopExample = new ThreadStopExample();
		threadStopExample.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadStopExample.stop();
	}
}
