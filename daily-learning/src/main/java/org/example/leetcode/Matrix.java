package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/14
 * @description: 二维数组中的查找
 */

public class Matrix {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		// 行数,表示二维数组有多少个元素
		int rows = matrix.length;
		// 列数，表示二维数组中每个一维数组内有多少个元素
		int cols = matrix[0].length;
		// 初始值
		int row = 0;
		int col = cols - 1;

		// 确保行和列都在二维数组的边界内
		while (row < rows && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
		Matrix matrix1 = new Matrix();
		boolean search = matrix1.findNumberIn2DArray(matrix, 5);
		System.out.println(search);
	}



}
