package org.example.gof.adapterpattern.slf4j;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description: log4j的具体实现
 */

public class Log4jLogger {

	void log(String message) {
		System.out.println("log4j: " + message);
	}
}
