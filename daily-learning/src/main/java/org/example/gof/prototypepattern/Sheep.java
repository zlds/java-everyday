package org.example.gof.prototypepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class Sheep implements Cloneable {

	private String name;

	public Sheep(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
