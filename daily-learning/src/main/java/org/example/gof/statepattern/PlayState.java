package org.example.gof.statepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description: 播放
 */

public class PlayState implements State {
	@Override
	public void pressPlay(Player player) {
		player.setState(new PauseState());
		System.out.println("播放音乐");
	}
}
