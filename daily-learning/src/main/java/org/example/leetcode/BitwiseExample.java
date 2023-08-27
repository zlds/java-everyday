package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/27
 * @description:
 */

public class BitwiseExample {



	/**
	 * 位与运算
	 * @param a
	 * @param b
	 * @return
	 */
	public static int bitAndOperator(int a, int b) {
		return a & b;
	}

	/**
	 * 位或运算
	 * @param a
	 * @param b
	 * @return
	 */
	public static int bitOrOperator(int a, int b) {
		return a | b;
	}

	/**
	 * 位异或运算
	 * @param a
	 * @param b
	 * @return
	 */
	public static int bitXorOperator(int a, int b) {
		return a ^ b;
	}

	/**
	 * 位非运算
	 * @param a
	 * @return
	 */
	public static int bitNotOperator(int a) {
		return ~a;
	}

	/**
	 * 左移运算
	 * @param a
	 * @return
	 */
	public static void leftShift(int a) {
		System.out.println("========左移开始========");
		// 二进制为101
		int num = 5;
		System.out.println("原始数字: " + num);
		// 向左移动一位。二进制为1010
		int result1 = num << 1;
		System.out.println("左移动1位: " + result1);
		// 向左移动二位
		int result2 = num << 2;
		System.out.println("左移2位: " + result2);
	}

	/**
	 * 右移运算
	 * @param a
	 */
	public static void rightShift(int a) {
		System.out.println("========右移开始========");
		// 二进制为101
		int num = 5;
		System.out.println("原始数字: " + num);
		// 向右移动一位。二进制为10
		int result1 = num >> 1;
		System.out.println("右移动1位: " + result1);
		// 向右移动二位
		int result2 = num >> 2;
		System.out.println("右移2位: " + result2);
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.println("原始值: a = " + a + "， b = " + b);
		a = a ^ b;
		b = a ^ b ;
		a = a ^ b;
		System.out.println("交换之后的值: a = " + a + "， b = " + b);
		// 位与运算
		System.out.println(bitAndOperator(5,3));
		// 检查一个整数的某一位是否被设置。如果我们要检查一个数字第二位是否为1，我们可以使用按位与操作
		int num = 5;
		boolean isBitSet = (num & 4) != 0;
		System.out.println("Is the 2 and bit set? " + isBitSet);
		// 位或运算
		System.out.println("位或运算5|3= " + bitOrOperator(5,3));
		// 位异或运算
		System.out.println("位异或运算5^3= " + bitXorOperator(3,3));
		// 左移运算符
		leftShift(5);
		// 右移运算符
		rightShift(5);
	}
}
