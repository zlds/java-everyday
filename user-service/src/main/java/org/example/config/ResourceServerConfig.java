package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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
	    /*// 远程调用认证服务检查用户是否登录
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setClientId("user-server");
		remoteTokenServices.setClientSecret("xyz");
		remoteTokenServices.setCheckTokenEndpointUrl("http://127.0.0.1:10010/oauth/check_token");
		resources.tokenServices(remoteTokenServices);*/
		// JWT无状态认证,不在依赖远程认证服务器
		resources.resourceId("user-server").tokenStore(tokenStore()).stateless(true);
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

	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	/**
	 * JWT Token转换器
	 * @return
	 */
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey("oauth2");
		jwtAccessTokenConverter.setVerifier(new MacSigner("oauth2"));
		return jwtAccessTokenConverter;
	}
}
