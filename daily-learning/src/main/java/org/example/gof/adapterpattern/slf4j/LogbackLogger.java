package org.example.gof.adapterpattern.slf4j;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description: logback的具体实现
 */

public class LogbackLogger {

	void log(String message) {
		System.out.println("Logback: " + message);
	}
}
