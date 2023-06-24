package org.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: hanchaowei
 * @date 2023/6/24
 * @description:
 */

@Configuration
public class UserServiceConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
