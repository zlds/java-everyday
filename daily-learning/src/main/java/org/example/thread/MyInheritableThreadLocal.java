package org.example.thread;

import com.alibaba.fastjson2.JSONObject;

/**
 * @author: hanchaowei
 * @date 2024/7/13
 * @description:
 */

public class MyInheritableThreadLocal<T> extends InheritableThreadLocal<T> {

	// 重写父类方法,实现深拷贝
	@Override
	protected T childValue(T parentValue) {
		String jsonString = JSONObject.toJSONString(parentValue);
		return (T) JSONObject.parseObject(jsonString, parentValue.getClass());
	}
}
