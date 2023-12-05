package org.example.sync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: hanchaowei
 * @date 2023/12/5
 * @description: 异步编程实际场景使用示例。 模拟一个在线购物场景,需要调用三个不同的服务,并聚合结果。
 */

public class OnlineShoppingExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 模拟调用不同的服务
		CompletableFuture<String> productInfo = getProductInfo("001");
		CompletableFuture<String> userReviews = getUserReviews("001");
		CompletableFuture<Double> discount = getDiscount("001");

		// 等待所有异步操作完成,并聚合结果
		CompletableFuture<Void> allFutures = CompletableFuture.allOf(
				productInfo,
				userReviews,
				discount
		);

		// 当所有异步操作完成后,执行回调函数
		CompletableFuture<String> finalResult = allFutures.thenApply( v -> {
			try {
				// 聚合结果
				String productInfoResult = productInfo.get();
				String userReviewsResult = userReviews.get();
				Double discountResult = discount.get();
				return String.format("Product Info: %s\nReviews: %s\nDiscount: %.2f%%", productInfoResult, userReviewsResult, discountResult);
			} catch (InterruptedException | ExecutionException e) {
				return "Error retrieving result: " + e.getMessage();
			}
		});
		// 阻塞并等待finalResult完成。实际场景中,要使用回调函数/消息驱动/定期轮询检查,而不是阻塞等待。
		System.out.println(finalResult.get());
	}


	/**
	 * 异步获取产品信息
	 * @param productId
	 * @return
	 */
	private static CompletableFuture<String> getProductInfo(String productId) {
		return CompletableFuture.supplyAsync(() -> {
			// 模拟阻塞
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Product Info: " + "iPhone 15 Pro Max";
		});
	}

	/**
	 * 异步获取用户评论
	 * @param productId
	 * @return
	 */
	private static CompletableFuture<String> getUserReviews(String productId) {
		return CompletableFuture.supplyAsync(() -> {
			// 模拟阻塞
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "User Reviews: " + "100 stars";
		});
	}

	/**
	 * 异步获取折扣信息
	 * @param productId
	 * @return
	 */
	private static CompletableFuture<Double> getDiscount(String productId) {
		return CompletableFuture.supplyAsync(() -> {
			// 模拟阻塞
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 20.0;
		});
	}
}
