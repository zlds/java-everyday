package org.example.designmodel.singlemodel;

/**
 * @author: hanchaowei
 * @date 2023/3/7
 * @description: 懒汉模式
 */

public class IdlerSingleMode {
	// 懒汉模式,用到时创建
	private static  IdlerSingleMode instance = null;

	public IdlerSingleMode() {
	}

	public static IdlerSingleMode getInstance() {
		if (instance == null) {
			instance = new IdlerSingleMode();
		}
		return instance;
	}


}
