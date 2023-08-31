package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/31
 * @description:
 */

public class RecursionExample {

	/**
	 * 吃巧克力
	 * 要求每次只能吃一块，吃完需要几次
	 * @param count
	 * @return
	 */
	public int eatChocolate(int count) {
		if (count == 0) {
			return 0;
		}
		return 1 + eatChocolate(count - 1);
	}

	/**
	 * 打印倒计时
	 * @param number
	 * @return
	 */
	public int printCountDown(int number) {
		if (number == 0) {
			return 0;
		}
		System.out.println(number);
		return printCountDown(number - 1);
	}


	/**
	 * 总和
	 * @param n
	 * @return
	 */
	public int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	/**
	 * 阶乘
	 * @param n
	 * @return
	 */
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}


	/**
	 * 汉诺塔
	 * @param n 盘子个数
	 * @param from 开始的柱子
	 * @param aux 中间的柱子
	 * @param to 目标柱子
	 */
	public void hanoi(int n, char from, char aux, char to) {
		if (n == 1) {
			System.out.println("第1个盘子从" + from + "移动到" + to);
			return;
		}
		// 将n-1个盘子从A移动到B
		hanoi(n - 1, from , to, aux);

		System.out.println("移动第" + n + "个盘子从" + from + "移动到" + to);
		// 将n-1个盘子从B移动到C
		hanoi(n - 1, aux, from, to);
	}

	public static void main(String[] args) {
		RecursionExample recursionExample = new RecursionExample();
		recursionExample.hanoi(3, 'A', 'B', 'C');
	}



















}
