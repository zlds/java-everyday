package org.example.gof.prototypemodel;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class TennisPlayer {
	public static void main(String[] args) {
		TennisRacketPrototypeManager.buildProtypes();
		for (int i = 0; i < 10; i++) {
			RacketPrototype r1 = TennisRacketPrototypeManager.getCloneRacket("pro staff");
		}
	}
}
