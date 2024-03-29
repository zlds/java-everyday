package org.example.gof.buildepattern;

import org.springframework.util.StringUtils;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ResourcePoolConfigV1 {
	private static final int DEFAULT_MAX_TOTAL = 8;
	private static final int DEFAULT_MAX_IDLE = 8;
	private static final int DEFAULT_MIN_IDLE = 0;

	private String name;
	private int maxTotal = DEFAULT_MAX_TOTAL;
	private int maxIdle = DEFAULT_MAX_IDLE;
	private int minIdle = DEFAULT_MIN_IDLE;

	// v1 版本通过构造函数传参的方式
	public ResourcePoolConfigV1(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("name should not be empty.");
		}
		this.name = name;

		if ( maxTotal != null ) {
			if (maxTotal <= 0) {
				throw new IllegalArgumentException("maxTotal should be positive.");
			}
			this.maxTotal = maxTotal;
		}

		if (maxIdle != null ) {
			if (maxIdle <= 0) {
				throw new IllegalArgumentException("maxIdle should be positive.");
			}
			this.maxIdle = maxIdle;
		}

		if (minIdle != null) {
			if (minIdle <= 0) {
				throw new IllegalArgumentException("minIdle should be positive.");
			}
			this.minIdle = minIdle;
		}
	}
}
