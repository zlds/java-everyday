package org.example.gof.statepattern.geektime.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class ApplicationDemo {
	public static void main(String[] args) {
		MarioStateMachine mario = new MarioStateMachine();
		mario.obtainMushRoom();
		int score = mario.getScore();
		State currentState = mario.getCurrentState();
		System.out.println("mario score: " + score + "; state: " + currentState);
	}
}
