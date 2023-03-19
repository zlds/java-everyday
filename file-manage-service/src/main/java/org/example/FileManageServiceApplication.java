package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author: hanchaowei
 * @date 2023/3/17
 * @description:
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("org.example.dao")
public class FileManageServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileManageServiceApplication.class);
	}
}
