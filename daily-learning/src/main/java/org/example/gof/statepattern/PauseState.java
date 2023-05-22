package org.example.gof.statepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description: 暂停
 */

public class PauseState implements State {
	@Override
	public void pressPlay(Player player) {
		player.setState(new PlayState());
		System.out.println("暂停音乐");
	}
}
