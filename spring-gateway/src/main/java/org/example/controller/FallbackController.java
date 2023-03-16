package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;


/**
 * @author: hanchaowei
 * @date 2023/3/14
 * @description:
 */

@RestController
public class FallbackController {
	private Logger logger = LoggerFactory.getLogger(FallbackController.class);

	@GetMapping("/fallback")
	public String fallback(ServerWebExchange exchange) {
		Throwable executionException = exchange.getAttribute(ServerWebExchangeUtils.HYSTRIX_EXECUTION_EXCEPTION_ATTR);
		logger.error("网关执行请求失败:{}", executionException.getMessage());
		return "服务降级，请稍后再试" + executionException.getMessage();
	}

}
