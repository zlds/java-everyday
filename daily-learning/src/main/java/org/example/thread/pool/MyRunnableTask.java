package org.example.thread.pool;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description: Runnable无返回值。如果需要返回值，可以使用Callable。
 * (如果需要在线程执行结束后获取一个结果，可以在run方法内部更新共享变量)
 */

public class MyRunnableTask implements Runnable {

	@Override
	public void run() {
		// 这里可以执行任务，但没有返回值
		System.out.println("任务完成");
	}
}
