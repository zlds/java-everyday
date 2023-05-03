package org.example.gof.factorypattern;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description:
 */

public class DatabaseLoggerFactory extends LoggerFactory {

	@Override
	public Logger createLogger() {
		return new DatabaseLogger();
	}
}
