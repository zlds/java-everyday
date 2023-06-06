package com.example.springrocketmq.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2023/6/6
 * @description:
 */

@RestController
@RequestMapping("/producer")
public class ProducerController {


	@Autowired
	private RocketMQTemplate rocketMQTemplate;


	@GetMapping("/send")
	public String send(String message) {
		rocketMQTemplate.convertAndSend("test-topic",message);
		return "发送成功";
	}
}
