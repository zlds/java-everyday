package org.example.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author: hanchaowei
 * @date 2024/5/14
 * @description: 事件工厂
 */

public class TradeTransactionFactory implements EventFactory<TradeTransaction> {

	@Override
	public TradeTransaction newInstance() {
		return new TradeTransaction();
	}
}
