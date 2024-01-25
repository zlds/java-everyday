package org.example.designmodel.singlemodel;

/**
 * @author: hanchaowei
 * @date 2023/3/7
 * @description: 单例模式
 */

public class HungrySingleMode {
	// 饿汉模式,提前创建
	private static  HungrySingleMode instance = new HungrySingleMode();

	private HungrySingleMode() {
	}


	public static HungrySingleMode getInstance() {
		return instance;
	}
}
