package org.example.gof.apaptermodel;

/**
 * @author: hanchaowei
 * @date 2023/5/1
 * @description: 适配器: 将欧洲插头适配成美国插头
 */

public class PlugAdapter implements AmericanPlug {
	private EuropeanPlug europeanPlug;
	public PlugAdapter(EuropeanPlug europeanPlug) {
		this.europeanPlug = europeanPlug;
	}

	@Override
	public void threePinPlug() {
		europeanPlug.twoPinPlug();
		System.out.println("我是适配器，我可以将欧洲两脚插头适配成美国三脚插头");
	}
}
