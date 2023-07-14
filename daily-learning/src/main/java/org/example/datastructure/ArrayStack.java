package org.example.datastructure;

/**
 * @author: hanchaowei
 * @date 2023/7/13
 * @description: 基于数组实现的顺序栈
 */

public class ArrayStack {
	// 定义数组
	private String[] items;
	// 栈大小
	private int n;
	// 元素个数
	private int count;


	public ArrayStack(int n) {
		this.items = new String[n];
		this.n = n;
		this.count = 0;
	}

	public boolean push(String s) {
		// 空间是否满
		if (count == n) {
			return false;
		}
		items[count] = s;
		count++;
		return true;
	}

	public String pop() {
		// 栈为空返回null
		if (count == 0) {
			return null;
		}
		String tmp = items[count-1];
		--count;
		return tmp;
	}


	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		arrayStack.push("1");
		arrayStack.push("2");
		arrayStack.push("3");
		arrayStack.push("4");
		arrayStack.push("5");
		arrayStack.push("6");
		System.out.println(arrayStack.pop());
	}


}
