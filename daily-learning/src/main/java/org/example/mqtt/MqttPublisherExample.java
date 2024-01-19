package org.example.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author: hanchaowei
 * @date 2024/1/19
 * @description: 发布者示例
 */

public class MqttPublisherExample {

	public static void main(String[] args) {
		String broker = "tcp://localhost:1883";
		String topic = "test/topic";
		// 基于clientID创建连接
		String clientId = "test";
		// 用户名
		String userName = "test";
		String password = "123456//";
		// 发送内容
		String content = "Hello MQTT";
		// QoS
		int qos = 2;

		try {
			MqttClient mqttClient = new MqttClient(broker, clientId,new MemoryPersistence());
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(userName);
			connOpts.setPassword(password.toCharArray());

			System.out.println("Connecting to broker: " + broker);
			mqttClient.connect(connOpts);
			System.out.println("Connected");

			System.out.println("Publishing message: " + content);
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			mqttClient.publish(topic, message);
			System.out.println("Message published");

			mqttClient.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}
}
