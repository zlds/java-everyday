package org.example.gof.strategypattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public interface DiscountStrategy {
	double calDiscount(Order order);
}
