package org.example.gof.statepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description: 播放器状态
 */

public interface State {
	/**
	 * 按下播放按钮
	 * @param player
	 */
	void pressPlay(Player player);
}
