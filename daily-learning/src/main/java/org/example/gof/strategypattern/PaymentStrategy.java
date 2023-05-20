package org.example.gof.strategypattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description: 支付策略接口
 */

public interface PaymentStrategy {
	void pay(int amount);
}
