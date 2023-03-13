package org.example.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: hanchaowei
 * @date 2023/3/13
 * @description:
 */

@Configuration
public class GatewayConfig {

	@Bean
	public KeyResolver ipKeyResolver() {
		return new KeyResolver() {
			@Override
			public Mono<String> resolve(ServerWebExchange exchange) {
				/**
				 * 获取请求ip
				 */
				return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
			}
		};
	}
}
