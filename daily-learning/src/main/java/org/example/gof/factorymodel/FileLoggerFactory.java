package org.example.gof.factorymodel;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description:
 */

public class FileLoggerFactory extends LoggerFactory {
	@Override
	public Logger createLogger() {
		return new FileLogger();
	}
}
