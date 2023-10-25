package org.example.gof.adapterpattern.slf4j;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description:
 */

public class Test {
	public static void main(String[] args) {
		// 使用log4j
		Log4jLogger log4jLogger = new Log4jLogger();
		Slf4jLogger slf4jLogger = new Log4jAdapter(log4jLogger);
		slf4jLogger.log("log4j test");

		// 使用logback
		LogbackLogger logbackLogger = new LogbackLogger();
		Slf4jLogger logger2 = new LogbackAdapter(logbackLogger);
		logger2.log("Hello World");
	}
}
