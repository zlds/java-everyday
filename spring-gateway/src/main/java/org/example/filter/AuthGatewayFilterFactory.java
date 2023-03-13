package org.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/3/13
 * @description: 自定义过滤器实现登录拦截校验
 */

@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

	public AuthGatewayFilterFactory() {
		super(AuthGatewayFilterFactory.Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		/**
		 * 测试token和userId
		 */
		Map<String,Integer> tokenMap = new HashMap<>();
		tokenMap.put("user",100);

		return new GatewayFilter() {
			@Override
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				/**
				 * 获取token
				 */
				String token = exchange.getRequest().getHeaders().getFirst(config.getTokenHeaderName());

				/**
				 * 如果获取不到token，则不进行认证。无需认证的API接口
				 */
				if (!StringUtils.hasText(token)) {
					chain.filter(exchange);
				}
				// 进行校验token
				ServerHttpResponse response = exchange.getResponse();
				Integer userId = tokenMap.get(token);
				if (userId == null) {
					// 返回401 状态码
					response.setStatusCode(HttpStatus.UNAUTHORIZED);
					// 如果不添加乱码。也可以修改buffer的编码
					response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
					DataBuffer buffer = exchange.getResponse().bufferFactory().wrap("认证不通过".getBytes());
					return response.writeWith(Flux.just(buffer));
				}
				// 将userId放入header中
				ServerHttpRequest request = exchange.getRequest().mutate().header(config.getUserIdHeaderName(), userId.toString()).build();
				return chain.filter(exchange.mutate().request(request).build());
			}
		};

	}


	public static class Config {

		/**
		 * 默认的token头名称
		 */
		private static final String DEFAULT_TOKEN_HEADER_NAME = "token";
		/**
		 * 默认头名称
		 */
		private static final String DEFAULT_HEADER_NAME = "user-id";


		private String tokenHeaderName = DEFAULT_TOKEN_HEADER_NAME;
		private String userIdHeaderName = DEFAULT_HEADER_NAME;

		public String getTokenHeaderName() {
			return tokenHeaderName;
		}

		public String getUserIdHeaderName() {
			return userIdHeaderName;
		}

		public Config setTokenHeaderName(String tokenHeaderName) {
			this.tokenHeaderName = tokenHeaderName;
			return this;
		}

		public Config setUserIdHeaderName(String userIdHeaderName) {
			this.userIdHeaderName = userIdHeaderName;
			return this;
		}
	}
}
