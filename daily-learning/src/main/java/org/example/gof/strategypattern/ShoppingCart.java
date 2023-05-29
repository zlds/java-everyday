package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description: 购物车
 */

public class ShoppingCart {
	// 购物车中的支付策略
	private PaymentStrategy paymentStrategy;
	// 购物车中商品总价
	private int totalAmount;

	public ShoppingCart(PaymentStrategy paymentStrategy, int totalAmount) {
		this.paymentStrategy = paymentStrategy;
		this.totalAmount = totalAmount;
	}

	public void checkout() {
		paymentStrategy.pay(totalAmount);
	}
}
