package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class BitcoinPaymentStrategy implements PaymentStrategy {
	@Override
	public void pay(int amount) {
		System.out.println("比特币支付了：" + amount + "元");
	}
}
