package org.example.gof.buildemodel;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ResourcePoolConfigV2 {
	private static final int DEFAULT_MAX_TOTAL = 8;
	private static final int DEFAULT_MAX_IDLE = 8;
	private static final int DEFAULT_MIN_IDLE = 0;

	private String name;
	private int maxTotal = DEFAULT_MAX_TOTAL;
	private int maxIdle = DEFAULT_MAX_IDLE;
	private int minIdle = DEFAULT_MIN_IDLE;

	// v2版本 通过setter函数设置
	public ResourcePoolConfigV2(String name) {
		this.name = name;
	}

	public void setMaxTotal(Integer maxTotal) {
		if (maxTotal != null) {
			if (maxTotal <= 0) {
				throw new IllegalArgumentException("maxTotal should be positive.");
			}
			this.maxTotal = maxTotal;
		}
	}

	public void setMaxIdle(Integer maxIdle) {
		if (maxIdle != null) {
			if (maxIdle <= 0) {
				throw new IllegalArgumentException("maxIdle should be positive.");
			}
			this.maxIdle = maxIdle;
		}
	}

	public void setMinIdle(Integer minIdle) {
		if (minIdle != null) {
			if (minIdle <= 0) {
				throw new IllegalArgumentException("minIdle should be positive.");
			}
			this.minIdle = minIdle;
		}
	}
}
