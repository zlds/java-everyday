package org.example.gof.statepattern.geektime.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public enum State {

	SMALL(0),
	SUPER(1),
	FIRE(2),
	CAPE(3);


	private int value;


	State(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
