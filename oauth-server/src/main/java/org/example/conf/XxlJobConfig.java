package org.example.conf;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: hanchaowei
 * @date 2023/5/14
 * @description:
 */
@Configuration
@RefreshScope
public class XxlJobConfig {
	@Value("${xxl.job.admin.addresses}")
	private String adminAddresses;

	@Value("${xxl.job.executor.appname}")
	private String appName;

	@Value("${xxl.job.executor.ip}")
	private String ip;

	@Value("${xxl.job.executor.port}")
	private int port;

	@Value("${xxl.job.accessToken}")
	private String accessToken;

	@Bean
	public XxlJobSpringExecutor xxlJobExecutor() {
		XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
		xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
		xxlJobSpringExecutor.setAppname(appName);
		xxlJobSpringExecutor.setIp(ip);
		xxlJobSpringExecutor.setPort(port);
		xxlJobSpringExecutor.setAccessToken(accessToken);
		return xxlJobSpringExecutor;
	}

}

