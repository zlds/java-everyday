package org.example.gof.statepattern.geektime.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class MarioStateMachine {
	private int score;
	private State currentState;

	public MarioStateMachine() {
		this.score = 0;
		this.currentState = State.SMALL;
	}

	/**
	 * 获得蘑菇
	 */
	public void obtainMushRoom() {
		if (currentState.equals(State.SMALL)) {
			this.currentState = State.SUPER;
			this.score += 100;
		}
	}

	/**
	 * 获得斗篷
	 */
	public void obtainCape() {
		if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
			this.currentState = State.CAPE;
			this.score += 200;
		}
	}

	/**
	 * 获得火焰
	 */
	public void obtainFireFlower() {
		if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
			this.currentState = State.FIRE;
			this.score += 300;
		}
	}

	/**
	 * 遇到怪物
	 */
	public void meetMonster() {
		// 分支逻辑法，参照状态转移图，将每一个状态转移，都用一个if-else分支来表示。
		// 但是，这种实现方式有两个问题：
		// 1. 对于复杂的状态机来说，这种实现方式极易漏写或者写错某个状态转移。
		// 2. 如果状态特别多，代码就会变得特别长，可维护性和可扩展性都不好。
		if (currentState.equals(State.SUPER)) {
			this.currentState = State.SMALL;
			this.score -= 100;
			return;
		}
		if (currentState.equals(State.CAPE)) {
			this.currentState = State.SMALL;
			this.score -= 200;
			return;
		}
	}
	public int getScore() {
		return this.score;
	}

	public State getCurrentState() {
		return this.currentState;
	}

}
