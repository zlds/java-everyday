package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/30
 * @description: 岛屿数量
 */

public class NumIslands {


	public int numIslands(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}
		// 行数
		int numRows = grid.length;
		// 列数
		int numCols = grid[0].length;
		// 岛屿数量
		int count = 0;


		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (grid[row][col] == 1) {
					count++;
					dfs(grid,row,col);
				}
			}
		}
		return count;
	}

	private void dfs(int[][] grid, int row, int col) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
			return;
		}

		// 标记此位置为已访问
		grid[row][col] = 0;

		// 上面的邻居
		dfs(grid,row - 1, col);
		// 下面的邻居
		dfs(grid,row + 1,col);
		// 左邻居
		dfs(grid,row,col - 1);
		// 右邻居
		dfs(grid,row,col + 1);
	}

	public static void main(String[] args) {
		NumIslands islands  = new NumIslands();
		int[][] grid = new int[][]{{1,1,0,0,0},{0,1,0,1,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,1,1,1}};
		System.out.println(islands.numIslands(grid));
	}
}
