package org.example.gof.statepattern.geektime.v2;

import static org.example.gof.statepattern.geektime.v2.State.*;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class MarioStateMachine {
	private int score;
	private State currentState;

	private static final State[][] transitionTable = {
			{SUPER, CAPE, FIRE, SMALL},
			{SUPER, CAPE, FIRE, SMALL},
			{CAPE, CAPE, CAPE, SMALL},
			{FIRE, FIRE, FIRE, SMALL}
	};

	private static final int[][] actionTable = {
			{+100,+200,+300,+0},
			{+0,+200,+300,-100},
			{+0,+0,+0,-200},
			{+0,+0,+0,-300}
	};

	public MarioStateMachine() {
		this.score = 0;
		this.currentState = SMALL;
	}

	/**
	 * 获得蘑菇
	 */
	public void obtainMushRoom() {
		executeEvent(Event.GOT_CAPE);
	}

	/**
	 * 获得斗篷
	 */
	public void obtainCape() {
		executeEvent(Event.GOT_CAPE);
	}

	/**
	 * 获得火焰
	 */
	public void obtainFireFlower() {
		executeEvent(Event.GOT_FIRE);
	}

	/**
	 * 遇到怪物
	 */
	public void meetMonster() {
		executeEvent(Event.MET_MONSTER);
	}

	private void executeEvent(Event event) {
		int stateValue = currentState.getValue();
		int eventValue = event.getValue();
		this.currentState = transitionTable[stateValue][eventValue];
		this.score += actionTable[stateValue][eventValue];
	}

	public int getScore() {
		return this.score;
	}

	public State getCurrentState() {
		return this.currentState;
	}
}
