package org.example.gof.adapterpattern.slf4j;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description: logback的适配器
 */

public class LogbackAdapter implements Slf4jLogger {
	private LogbackLogger logbackLogger;

	public LogbackAdapter(LogbackLogger logbackLogger) {
		this.logbackLogger = logbackLogger;
	}

	@Override
	public void log(String message) {
		logbackLogger.log(message);
	}
}
