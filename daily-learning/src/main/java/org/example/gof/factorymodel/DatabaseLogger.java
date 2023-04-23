package org.example.gof.factorymodel;

/**
 * @author: hanchaowei
 * @date 2023/4/23
 * @description:
 */

public class DatabaseLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("DataBaseLogger: " + message);
	}
}
