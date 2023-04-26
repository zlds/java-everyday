package org.example.di;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class MessageSender {
	public void send(String cellphone, String message) {
		System.out.println("send message to " + cellphone + " : " + message);
	}
}
