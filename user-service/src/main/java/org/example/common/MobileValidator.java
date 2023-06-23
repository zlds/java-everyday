package org.example.common;

import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: hanchaowei
 * @date 2023/6/23
 * @description: 手机号校验
 */

public class MobileValidator implements ConstraintValidator<Mobile,String> {
	@Autowired
	private IUserService iUserService;

	@Override
	public void initialize(Mobile constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return false;
		}

		// 正则校验
		if (!value.matches("^1[3-9]\\d{9}$")) {
			return false;
		}
		// 检查手机号是否被注册
		if (iUserService.isRegistered(value)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("手机号已被注册").addConstraintViolation();
			return false;
		}
		return true;
	}
}
