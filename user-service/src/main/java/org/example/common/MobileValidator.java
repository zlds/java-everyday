package org.example.common;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: hanchaowei
 * @date 2023/6/23
 * @description: 手机号校验
 */

public class MobileValidator implements ConstraintValidator<Mobile,String> {
	@Override
	public void initialize(Mobile constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		return value.matches("^1[3-9]\\d{9}$");
	}
}
