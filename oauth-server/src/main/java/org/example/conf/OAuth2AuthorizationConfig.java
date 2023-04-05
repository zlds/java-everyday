package org.example.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;


/**
 * @author: hanchaowei
 * @date 2023/4/1
 * @description:
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;

	/**
	 * 客户端id
	 */
	private static final String CLIENT_ID = "user-server";

	/**
	 * 客户端秘钥
	 */
	private static final String SECRET_CHAR_SEQUENCE = "xyz";
	private static final String ALL = "all";

	/**
	 * 令牌失效期
	 */
	private static final int ACCESS_TOKEN_VALIDITY_SECONDS = 30 * 60;

	/**
	 * 密码模式
	 */
	private static final String GRANT_TYPE_PASSWORD = "password";

	/**
	 * 授权码模式
	 */
	private static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";

	/**
	 * 简化授权码模式
	 */
	private static final String GRANT_TYPE_IMPLICIT = "implicit";

	/**
	 * 客户端模式
	 */
	private static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";


	public OAuth2AuthorizationConfig() {
		super();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
		security
				// 允许表单认证
				.allowFormAuthenticationForClients()
				// 允许token_key的访问权限
				.tokenKeyAccess("permitAll()")
				// 允许check_token访问
				.checkTokenAccess("permitAll()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		super.configure(clients);
		// 内存存储
		/*clients.inMemory()
				.withClient(CLIENT_ID)
				.secret(SECRET_CHAR_SEQUENCE)
				.autoApprove(false)
				.authorizedGrantTypes(GRANT_TYPE_PASSWORD, GRANT_TYPE_AUTHORIZATION_CODE, GRANT_TYPE_IMPLICIT, GRANT_TYPE_CLIENT_CREDENTIALS)
				.scopes(ALL)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				// 授权成功后跳转地址,如果前端传了redirect_uri不在列表中将会报错
				.redirectUris("https://www.baidu.com","https://www.qq.com");*/
		// 数据库加载认证信息
		clients.withClientDetails(jdbcClientDetailsService());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		super.configure(endpoints);
		endpoints
				// token存储方法。TODO 暂时存放到内存中
//				.tokenStore(new InMemoryTokenStore())
				// JWT认证
				.tokenStore(tokenStore())
				// token服务器
				.tokenServices(authorizationServerTokenServices())
				.authenticationManager(authenticationManager)
				// 获取token方法
				.allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
	}

	public AuthorizationServerTokenServices authorizationServerTokenServices() {
		// 使用默认实现
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		// 开启刷新令牌
		defaultTokenServices.setSupportRefreshToken(true);

		// JWT设置
		defaultTokenServices.setTokenEnhancer(jwtAccessTokenConverter());
		// 注释内存存储
//		defaultTokenServices.setTokenStore(new InMemoryTokenStore());
		defaultTokenServices.setTokenStore(tokenStore());
		// 设置令牌有效时间
		defaultTokenServices.setAccessTokenValiditySeconds(20);
		defaultTokenServices.setRefreshTokenValiditySeconds(259200);
		return defaultTokenServices;
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

	/**
	 * 数据库中获取客户端id
	 */
	@Bean
	public JdbcClientDetailsService jdbcClientDetailsService() {
		return new JdbcClientDetailsService(dataSource);

	}
}
