package org.example.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: hanchaowei
 * @date 2023/5/18
 * @description: 优先级队列
 */

public class PriorityQueueTest {
	public static void main(String[] args) {
		UserVO u1 = new UserVO().setId(1L).setName("1").setLevel(1);
		UserVO u2 = new UserVO().setId(2L).setName("2").setLevel(2);
		UserVO u3 = new UserVO().setId(3L).setName("3").setLevel(3);


		PriorityQueue queue = new PriorityQueue<>(10, new Comparator<UserVO>() {
			@Override
			public int compare(UserVO o1, UserVO o2) {
				return o2.getLevel() - o1.getLevel();
			}
		});
		queue.add(u1);
		queue.add(u2);
		queue.add(u3);

		while (!queue.isEmpty()) {
			UserVO poll = (UserVO) queue.poll();
			System.out.println("name=" + poll.getName() + " level=" + poll.getLevel());

		}

	}
}
