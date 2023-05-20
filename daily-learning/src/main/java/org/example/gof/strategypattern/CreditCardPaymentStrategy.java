package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description: 信用卡支付
 */

public class CreditCardPaymentStrategy implements PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println("信用卡支付了：" + amount + "元");
	}
}
