package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/8/19
 * @description: 判断一棵树是否为完全二叉树
 */

public class IsCompleteBinary {


	/**
	 * 判断一棵树是否为完全二叉树
	 * @param root
	 * @return
	 */
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		// 标记是否遇到了null节点
		boolean flag = false;

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			// 如果遇到了null节点
			if (currentNode == null) {
				flag = true;
			} else {
				// 如果在null节点之后还遇到非null节点，则不是完全二叉树
				if (flag) {
					return false;
				}
				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {

		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;

		IsCompleteBinary isCompleteBinary = new IsCompleteBinary();
		System.out.println(isCompleteBinary.isComplete(treeNode1));
	}
















}
