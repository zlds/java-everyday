package org.example.beanlearn.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * @author: hanchaowei
 * @date 2023/3/25
 * @description: 加载证书到信任列表
 */

@Component
public class CustomCertificateLoadConfig {

	@PostConstruct
	public void init() {
		try {
			// 证书路径
			Resource resource = new ClassPathResource("anylogic/certificate/anylogic.pem");
			InputStream inputStream = resource.getInputStream();

			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);

			// 创建keystore对象，将证书添加到信任列表中
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			trustStore.setCertificateEntry("mycert", certificate);

			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
					TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(trustStore);
			// 创建SSLContext对象，用于创建SSL连接。TODO 目前指定了TLS1.2版本，后续可以考虑支持更多版本
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			// 初始化SSLContext，第一个参数是验证服务器证书的TrustManager数组，我们只有一个，因为只需要验证一种证书，所以为null
			// 第二个参数为SecureRandom对象，用于生成SSLSession ID，如果不需要可以为null
			// 第三个参数为null，使用默认的安全策略
			sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
			SSLContext.setDefault(sslContext);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
