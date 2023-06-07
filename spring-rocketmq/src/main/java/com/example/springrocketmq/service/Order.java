package com.example.springrocketmq.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hanchaowei
 * @date 2023/6/7
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private long id;
	private double price;

}
