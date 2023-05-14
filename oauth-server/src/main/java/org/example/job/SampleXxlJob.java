package org.example.job;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/5/14
 * @description:
 */

@Component

public class SampleXxlJob extends IJobHandler {
	private static final Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);

	@Override
	@XxlJob("test")
	public void execute() throws Exception {
		logger.info("我是Oauth2-Service服务哦: " + new Date());
	}
}
