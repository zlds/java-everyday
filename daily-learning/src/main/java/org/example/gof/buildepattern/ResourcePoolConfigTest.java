package org.example.gof.buildepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ResourcePoolConfigTest {
	public static void main(String[] args) {
		// v1版本 通过构造函数传参。如果参数不断变长，代码在可读性和易用性上都会变差。而且很容易传错。
		ResourcePoolConfigV1 resourcePoolConfigV1 = new ResourcePoolConfigV1("dbconnectionpool", 16, null, 8);

		/*
		v2版本 解决构成函数过长的问题，可以通过setter函数来给成员变量赋值，以替代冗长的构造函数。
		缺点: 1、如果必填参数很多退回v1版本；2、假设有一定的依赖关系，比如maxIdle依赖于maxTotal；
		3、如果我们希望ResourcePoolConfig的对象是不可变的，参数设置好就不运行修改。要实现这个功能，我们就不能在ResourcePoolConfig类中暴露set()方法了。
		 */
		ResourcePoolConfigV2 resourcePoolConfigV2 = new ResourcePoolConfigV2("dbconnectionpool");
		resourcePoolConfigV2.setMaxTotal(16);
		resourcePoolConfigV2.setMaxIdle(8);

		// v3版本 建造者模式。我们可以把校验逻辑、依赖关系，条件约束放到Builder类中。
		ResourcePoolConfigV3 resourcePoolConfigV3 = new ResourcePoolConfigV3.Builder().setName("dbconnectionpool")
				.setMaxTotal(16).setMaxIdle(10).setMinIdle(8).build();
	}
}
