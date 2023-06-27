package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/6/27
 * @description: 二叉树最小深度
 */

public class MinDepthTest {


	/**
	 * 二叉树最小深度(递归)
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null) {
			return minDepth(root.right) + 1;
		}

		if (root.right == null) {
			return minDepth(root.left) + 1;
		}

		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	/**
	 * 二叉树最小深度(广度优先遍历)
	 * @param root
	 * @return
	 */
	public static int minDepthBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current.left == null & current.right == null) {
					return depth;
				}

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
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(5);
		System.out.println("最小深度递归计算: " + minDepth(root));
		System.out.println("最小深度广度优先遍历计算: " + minDepthBFS(root));

	}
}
