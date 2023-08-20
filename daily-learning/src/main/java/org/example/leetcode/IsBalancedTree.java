package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/8/20
 * @description: 判断是否是平衡二叉树
 */

public class IsBalancedTree {


	/**
	 * 判断是否是平衡二叉树
	 * @param node
	 * @return
	 */
	public boolean isBalanced(TreeNode node) {
		return depth(node) != -1;
	}

	/**
	 * 递归获取二叉树的深度
	 * @param node
	 * @return
	 */
	public int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		// 如果左右子树的高度差大于1，或者左右子树有一个不是平衡二叉树，就返回-1
		if(Math.abs(leftDepth - rightDepth) > 1 || leftDepth == -1 || rightDepth == -1) {
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}


	/**
	 * 判断是否是平衡二叉树(广度优先遍历)
	 * @param node
	 * @return
	 */
	public boolean isBalancedForBFS(TreeNode node) {
		if (node == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			// 判断左右子树的高度差
			int leftDepth = getHeight(currentNode.left);
			int rightDepth = getHeight(currentNode.right);

			if (Math.abs(leftDepth - rightDepth) > 1) {
				return false;
			}

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return true;
	}


	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		// 树的高度
		int height = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.poll();
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}

				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
			height++;
		}
		return height;
	}


	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;

		IsBalancedTree isBalancedTree = new IsBalancedTree();
		System.out.println(isBalancedTree.isBalanced(node1));
		System.out.println(isBalancedTree.isBalancedForBFS(node1));
	}

}
