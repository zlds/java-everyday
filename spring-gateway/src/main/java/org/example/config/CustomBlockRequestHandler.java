package org.example.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: hanchaowei
 * @date 2023/3/15
 * @description:
 */

public class CustomBlockRequestHandler implements BlockRequestHandler {
	private static final String DEFAULT_BLOCK_MSG_PREFIX = "Blocked by Sentinel: ";
	@Override
	public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
		return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
				.contentType(MediaType.TEXT_PLAIN)
				.bodyValue(DEFAULT_BLOCK_MSG_PREFIX + throwable.getMessage());
	}
}
