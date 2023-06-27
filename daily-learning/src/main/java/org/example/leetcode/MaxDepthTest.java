package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/6/27
 * @description: 二叉树最大深度
 */

public class MaxDepthTest {

	/**
	 * 二叉树最大深度(递归)
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 获取左子树的最大深度
		int leftMaxDepth = maxDepth(root.left);
		// 获取右子树的最大深度
		int rightMaxDepth = maxDepth(root.right);
		// 取最大深度
		return Math.max(leftMaxDepth, rightMaxDepth) + 1;
	}


	/**
	 * 二叉树最大深度(广度优先遍历)
	 * @param root
	 * @return
	 */
	public static int maxDepthForBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 创建队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			depth++;
		}
		return depth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("递归计算: " + maxDepth(root));
		System.out.println("BFS计算: " + maxDepthForBFS(root));
	}
}
