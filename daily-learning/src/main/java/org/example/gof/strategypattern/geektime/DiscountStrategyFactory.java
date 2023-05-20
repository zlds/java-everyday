package org.example.gof.strategypattern.geektime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class DiscountStrategyFactory {
	private static final Map<OrderType,DiscountStrategy> strategies = new HashMap<>();

	static {
		strategies.put(OrderType.NORMAL,new NormalDiscountStrategy());
		strategies.put(OrderType.GROUPON,new GrouponDiscountStrategy());
		strategies.put(OrderType.PROMOTION,new PromotionDiscountStrategy());
	}

	public static DiscountStrategy getDiscountStrategy(OrderType type){
		return strategies.get(type);
	}





}
