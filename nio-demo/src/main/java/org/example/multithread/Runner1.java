package org.example.multithread;

/**
 * @author: hanchaowei
 * @date 2023/3/11
 * @description:
 */

public class Runner1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner1运行状态——————————" + i);
		}
	}
}
