package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class ShoppingCartTest {
	public static void main(String[] args) {
		// 创建购物车
		ShoppingCart shoppingCart = new ShoppingCart(new AliPaymentStrategy(), 300);
		// 结账
		shoppingCart.checkout();
	}
}
