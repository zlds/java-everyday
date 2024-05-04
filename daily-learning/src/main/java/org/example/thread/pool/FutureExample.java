package org.example.thread.pool;

import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2024/5/4
 * @description: Future示例
 */

public class FutureExample {


	public static Integer getPriceByS1() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}

	public static Integer getPriceByS2() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return 2;
	}

	public static Integer getPriceByS3() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return 3;
	}

	public static void save(Integer r) {
		System.out.println("保存价格：" + r);
	}

	public void example1() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// 异步向电商S1询价
		Future<Integer> f1 = executorService.submit(() -> getPriceByS1());
		// 异步向电商S2询价
		Future<Integer> f2 = executorService.submit(() -> getPriceByS2());
		// 异步向电商S3询价
		Future<Integer> f3 = executorService.submit(() -> getPriceByS3());
		// 获取电商S1报价并保存
		try {
			Integer r1 = f1.get();
			executorService.execute(() -> save(r1));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// 获取电商S2报价并保存
		try {
			Integer r2 = f2.get();
			executorService.execute(() -> save(r2));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// 获取电商S2报价并保存
		try {
			Integer r3 = f3.get();
			executorService.execute(() -> save(r3));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

	public void example2() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// 异步向电商S1询价
		Future<Integer> f1 = executorService.submit(() -> getPriceByS1());
		// 异步向电商S2询价
		Future<Integer> f2 = executorService.submit(() -> getPriceByS2());
		// 异步向电商S3询价
		Future<Integer> f3 = executorService.submit(() -> getPriceByS3());

		// 优化示例，由于s1的影响比较慢，即使s2和s3先拿到数据也要等待。所以我们这里增加一个阻塞队列，然后主线程消费这个阻塞队列。
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		// 电商 S1 报价异步进入阻塞队列
		executorService.execute(() -> {
			try {
				bq.put(f1.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		// 电商 S2 报价异步进入阻塞队列
		executorService.execute(() -> {
			try {
				bq.put(f2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		// 电商 S3 报价异步进入阻塞队列
		executorService.execute(() -> {
			try {
				bq.put(f3.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		// 异步保存所有报价
		for (int i = 0; i < 3; i++) {
			try {
				Integer r = bq.take();
				executorService.execute(() -> save(r));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		}
		executorService.shutdown();
	}


	public static void main(String[] args)  {
		FutureExample futureExample = new FutureExample();
		futureExample.example1();
		futureExample.example2();
	}

}
