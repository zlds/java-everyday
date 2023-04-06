package org.example.beanlearn.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/4/5
 * @description:
 */

@Profile("dev")
@Component
public class DevProfileServiceImpl implements MyProfileService {

	@Value("${profile}")
	private String profile;
	public void getMessage() {
		System.out.println(profile);;
	}
}
