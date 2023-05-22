package org.example.gof.statepattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public enum Event {
	GOT_MUSHROOM(0),
	GOT_CAPE(1),
	GOT_FIRE(2),
	MET_MONSTER(3);

	private int value;

	Event(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
