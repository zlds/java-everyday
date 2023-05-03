package org.example.gof.factorypattern;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description: 定义抽象类
 */

public interface Logger {
	/**
	 * 记录日志
	 * @param message
	 */
	void log(String message);
}
