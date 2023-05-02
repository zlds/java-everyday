package org.example.gof.buildemodel;

import org.springframework.util.StringUtils;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ResourcePoolConfigV3 {
	private String name;
	private int maxTotal;
	private int maxIdle;
	private int minIdle;

	private ResourcePoolConfigV3(Builder builder) {
		this.name = builder.name;
		this.maxTotal = builder.maxTotal;
		this.maxIdle = builder.maxIdle;
		this.minIdle = builder.minIdle;
	}


	public static class Builder {
		private static final int DEFAULT_MAX_TOTAL = 8;
		private static final int DEFAULT_MAX_IDLE = 8;
		private static final int DEFAULT_MIN_IDLE = 0;

		private String name;
		private int maxTotal = DEFAULT_MAX_TOTAL;
		private int maxIdle = DEFAULT_MAX_IDLE;
		private int minIdle = DEFAULT_MIN_IDLE;

		public ResourcePoolConfigV3 build() {
			// 校验逻辑，必填项校验，依赖关系校验，约束条件校验等
			if (StringUtils.isEmpty(name)) {
				throw new IllegalArgumentException("name should not be empty.");
			}
			if (maxIdle > maxTotal) {
				throw new IllegalArgumentException("maxIdle should be less than maxTotal.");
			}
			if (minIdle > maxTotal || minIdle > maxIdle) {
				throw new IllegalArgumentException("minIdle should be less than maxTotal and maxIdle.");
			}
			return new ResourcePoolConfigV3(this);
		}

		public Builder setName(String name) {
			if (StringUtils.isEmpty(name)) {throw new IllegalArgumentException("...");}
			this.name = name;
			return this;
		}

		public Builder setMaxTotal(int maxTotal) {
			if (maxTotal <= 0) {throw new IllegalArgumentException("...");}
			this.maxTotal = maxTotal;
			return this;
		}

		public Builder setMaxIdle(int maxIdle) {
			if (maxIdle < 0) {throw new IllegalArgumentException("...");}
			this.maxIdle = maxIdle;
			return this;
		}

		public Builder setMinIdle(int minIdle) {
			if (minIdle < 0) {throw new IllegalArgumentException("...");}
			this.minIdle = minIdle;
			return this;
		}
	}
}
