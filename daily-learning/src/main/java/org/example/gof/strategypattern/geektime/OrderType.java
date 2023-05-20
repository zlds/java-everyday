package org.example.gof.strategypattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public enum OrderType {

	NORMAL(1),
	GROUPON(2),
	PROMOTION(3);
	private int type;

	OrderType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}


}
