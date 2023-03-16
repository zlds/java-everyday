package org.example;


import com.alibaba.cloud.sentinel.gateway.ConfigConstants;
import com.alibaba.csp.sentinel.config.SentinelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: hanchaowei
 * @date 2023/3/12
 * @description:
 */

@SpringBootApplication
public class SpringGatewayApplication {
	public static void main(String[] args) {
		System.setProperty(SentinelConfig.APP_TYPE, ConfigConstants.APP_TYPE_SCG_GATEWAY);
		SpringApplication.run(SpringGatewayApplication.class, args);
	}
}
