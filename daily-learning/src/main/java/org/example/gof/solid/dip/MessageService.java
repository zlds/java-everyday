package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public class MessageService {

	private MessageProvider messageProvider;

	public MessageService(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public void send(String message) {
		messageProvider.sendMessage(message);
	}
}
