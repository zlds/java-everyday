package org.example.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description: 集合类不安全
 */

public class ListNoSafeDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(Thread.currentThread().getName() +  " " + list);
			},String.valueOf(i)).start();
		}
	}
}
