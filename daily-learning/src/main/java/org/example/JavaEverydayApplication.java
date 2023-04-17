package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: hanchaowei
 * @date 2023/4/17
 * @description:
 */

@SpringBootApplication
@EnableAspectJAutoProxy
public class JavaEverydayApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaEverydayApplication.class,args);
	}
}
