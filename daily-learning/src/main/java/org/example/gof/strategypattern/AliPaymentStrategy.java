package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class AliPaymentStrategy implements PaymentStrategy {
	@Override
	public void pay(int amount) {
		System.out.println("支付宝支付了：" + amount + "元");
	}
}
