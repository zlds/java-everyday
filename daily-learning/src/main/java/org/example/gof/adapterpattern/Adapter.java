package org.example.gof.adapterpattern;

/**
 * @author: hanchaowei
 * @date 2023/10/25
 * @description:
 */

public class Adapter implements OldInterface {

	private NewInterface newInterface;

	public Adapter(NewInterface newInterface) {
		this.newInterface = newInterface;
	}

	@Override
	public void oldMethod() {
		newInterface.newMethod();
	}

	public static void main(String[] args) {
		// 创建新类的实例
		NewInterface newInterface = new NewInterface();
		// 创建适配器实例,并将新类的实例传递给
		OldInterface adapter = new Adapter(newInterface);
		// 调用适配器的方法
		adapter.oldMethod();
	}
}
