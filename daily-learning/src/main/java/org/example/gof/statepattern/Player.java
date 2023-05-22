package org.example.gof.statepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class Player {
	private State state;

	public Player() {
		this.state = new PauseState();
	}

	public void pressPlay() {
		state.pressPlay(this);
	}

	public void setState(State state) {
		this.state = state;
	}
}
