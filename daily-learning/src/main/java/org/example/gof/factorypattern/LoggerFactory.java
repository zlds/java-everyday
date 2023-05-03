package org.example.gof.factorypattern;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description: 工厂接口
 */

public abstract class LoggerFactory {

	public abstract Logger createLogger();

	/**
	 * 静态工厂方法。根据客户端参数创建不同的工厂实例。
	 * @param type
	 * @return
	 */
	public static LoggerFactory getFactory(String type) {
		if ("file".equals(type)) {
			return new FileLoggerFactory();
		}
		if ("database".equals(type)) {
			return new DatabaseLoggerFactory();
		}
		throw new IllegalArgumentException("Invalid logger type: " + type);
	}
}
