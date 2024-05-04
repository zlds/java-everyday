package org.example.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/5/4
 * @description:
 */

public class ConcurrentModificationExceptionExample {

	public static void main(String[] args) {
		List<String> newList = new ArrayList<>();
		newList.add("A");
		newList.add("B");
		newList.add("C");
		newList.add("D");
		newList.add("E");

		/**
		 * 会抛出ConcurrentModificationException异常
		 * 迭代器在遍历过程中会检查modCount是否被修改，如果修改抛出异常。
		 */
		//		for (String s : newList) {
//			if ("C".equals(s)) {
//				newList.remove(s);
//			}
//		}

		// 正确操作
		Iterator<String> iterator = newList.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if ("C".equals(next)) {
				// 使用迭代器自己的remove方法，这样迭代器可以跟着modCount的变化。
				iterator.remove();
			}
		}
		System.out.println(newList);


	}

}
