package org.example.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author: hanchaowei
 * @date 2024/1/19
 * @description: 订阅者示例
 */

public class MqttSubscriberExample implements MqttCallback {

	public static void main(String[] args) {
		String broker = "tcp://localhost:1883";
		String topic = "test/topic";
		// 基于clientID创建连接
		String clientId = "test";
		// 用户名
		String userName = "test";
		String password = "123456//";

		try {
			MqttClient client = new MqttClient(broker, clientId,new MemoryPersistence());
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			options.setUserName(userName);
			options.setPassword(password.toCharArray());
			client.setCallback(new MqttSubscriberExample());
			client.connect(options);
			client.subscribe(topic);
			System.out.println("Subscribed to topic: " + topic);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 连接丢失
	 * @param throwable
	 */
	@Override
	public void connectionLost(Throwable throwable) {
		System.out.println("Connection lost: " + throwable.getMessage());

	}

	/**
	 * 消息到达
	 * @param s
	 * @param mqttMessage
	 * @throws Exception
	 */
	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		System.out.println("Received message:\n" +
				"Topic: " + s + "\t" +
				"Message: " + mqttMessage.toString()
		);
	}

	/**
	 * 消息发送完成
	 * @param iMqttDeliveryToken
	 */
	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
		System.out.println("发送完成---------" + iMqttDeliveryToken.isComplete());
	}
}
