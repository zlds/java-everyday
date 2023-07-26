package org.example.datastructure;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author: hanchaowei
 * @date 2023/7/26
 * @description:
 */

public class TreeSetTest {

	public static void main(String[] args) {
		// 创建一个Comparator
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 倒序
				return o2.compareTo(o1);
			}
		};

		TreeSet<Integer> numbers = new TreeSet<>(comparator);
		// 向TreeSet添加元素
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		// 输出TreeSet中的元素
		for (Integer number : numbers) {
			System.out.println(number);
		}


	}
}
