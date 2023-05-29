package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public interface MessageProvider {

	/**
	 * 发送消息
	 * @param message
	 */
	void sendMessage(String message);
}
