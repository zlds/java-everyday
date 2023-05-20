package org.example.gof.strategypattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class OrderService {

	// 未使用策略模式
//	public double discount(Order order) {
//		double discount = 0.0;
//		int type = order.getType();
//		if (type == OrderType.NORMAL.getType()) {
//			discount = 0.8;
//		} else if (type == OrderType.NORMAL.getType()) {
//			discount = 0.7;
//		} else if (type == OrderType.NORMAL.getType()) {
//			discount = 0.5;
//		}
//		return discount;
//	}

	// 策略模式
	public double discount(Order order) {

		DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(OrderType.NORMAL);
		return discountStrategy.calDiscount(order);
	}

}
