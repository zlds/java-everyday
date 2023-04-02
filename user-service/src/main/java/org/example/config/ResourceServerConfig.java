package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author: hanchaowei
 * @date 2023/4/2
 * @description:
 */

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	/**
	 * 校验token
	 * @param resources
	 * @throws Exception
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// 远程认证服务
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setClientId("user-server");
		remoteTokenServices.setClientSecret("xyz");
		remoteTokenServices.setCheckTokenEndpointUrl("http://127.0.0.1:10010/oauth/check_token");
		resources.tokenServices(remoteTokenServices);
	}

	/**
	 * 拦截URI规则
	 * @param http
	 * @throws Exception
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.and()
				.authorizeRequests()
				//  放行URL
				.antMatchers("/check/**").anonymous()
				// 其他拦截
				.anyRequest().authenticated();
	}
}
