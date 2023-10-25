package org.example.gof.adapterpattern.slf4j;

/**
 * @author: hanchaowei
 * @date 2023/10/11
 * @description:
 */

public class Log4jAdapter implements Slf4jLogger {
	private Log4jLogger log4jLogger;

	public Log4jAdapter(Log4jLogger log4jLogger) {
		this.log4jLogger = log4jLogger;
	}

	@Override
	public void log(String message) {
		log4jLogger.log(message);
	}
}
