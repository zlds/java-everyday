package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author: hanchaowei
 * @date 2023/4/1
 * @description:
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OauthServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class,args);
	}
}
