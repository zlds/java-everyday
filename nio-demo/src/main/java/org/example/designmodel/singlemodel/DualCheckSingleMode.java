package org.example.designmodel.singlemodel;

/**
 * @author: hanchaowei
 * @date 2023/3/7
 * @description:
 */

public class DualCheckSingleMode {
//	private static DualCheckSingleMode instance = null;
	// volatile关键字的作用是保证instance变量有序性，禁止指令重排序
	private static volatile DualCheckSingleMode instance = null;

	public DualCheckSingleMode() {
	}


	public static DualCheckSingleMode getInstance() {
		if (instance == null) {
			synchronized (DualCheckSingleMode.class) {
				/**
				 * 可能会发生指令重排序，导致instance不为空，但是对象还没有初始化完成,所以要加上volatile关键字
				 * 1.开辟空间
				 * 2.初始化对象
				 * 3.将对象指向空间
				 * 如果发生指令重排会出现1-3-2的情况，此时instance不为空，但是对象还没有初始化完成
				 */
				if (instance == null) {
					instance = new DualCheckSingleMode();
				}
			}
		}
		return instance;
	}
}
