package org.example.gof.strategypattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class GrouponDiscountStrategy implements DiscountStrategy {
	@Override
	public double calDiscount(Order order) {
		return 1;
	}
}
