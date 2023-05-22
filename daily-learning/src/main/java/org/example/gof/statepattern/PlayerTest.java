package org.example.gof.statepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class PlayerTest {
	public static void main(String[] args) {
		Player player = new Player();
		player.pressPlay(); // 输出：The player is playing.
		player.pressPlay(); // 输出：The player is paused.
		player.pressPlay(); // 输出：The player is playing.
	}
}
