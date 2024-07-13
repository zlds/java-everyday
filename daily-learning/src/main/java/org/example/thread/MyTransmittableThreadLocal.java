package org.example.thread;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author: hanchaowei
 * @date 2024/7/13
 * @description:
 */

public class MyTransmittableThreadLocal<T> extends TransmittableThreadLocal<T> {

	@Override
	public T copy(T parentValue) {
		String jsonString = JSONObject.toJSONString(parentValue);
		return (T) JSONObject.parseObject(jsonString, parentValue.getClass());

	}
}
