package org.example.gof.factorypattern;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description:
 */

public class Client {

	public static void main(String[] args) {
		LoggerFactory factory = LoggerFactory.getFactory("file");
		Logger logger = factory.createLogger();
		logger.log("This is a log message.");

		factory = LoggerFactory.getFactory("database");
		logger = factory.createLogger();
		logger.log("This is another log message.");
	}
}
