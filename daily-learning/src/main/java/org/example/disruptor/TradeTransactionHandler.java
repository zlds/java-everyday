package org.example.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author: hanchaowei
 * @date 2024/5/14
 * @description: 事件处理器
 */

public class TradeTransactionHandler implements EventHandler<TradeTransaction> {

	@Override
	public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
		// 处理交易逻辑
		System.out.println("Transaction: " + sequence + ", Price: " + event.getPrice());
	}
}
