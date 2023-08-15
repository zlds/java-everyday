package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: hanchaowei
 * @date 2023/8/15
 * @description: 二叉树中和为某一值的路径
 */

public class PathSumTest {

	/**
	 * 递归计算二叉树中和为某一值的路径
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		// 存储节点
		Stack<TreeNode> nodeStack = new Stack<>();
		// 存储路径
		Stack<List<Integer>> pathStack = new Stack<>();

		nodeStack.push(root);
		pathStack.push(Arrays.asList(root.val));

		while (!nodeStack.isEmpty()) {
			// 取出当前节点值
			TreeNode currentNode = nodeStack.pop();
			// 取出节点路径值
			List<Integer> currentPath = new ArrayList<>(pathStack.pop());
			// 如果是子节点，判断路径值是否等于targetSum
			if (currentNode.left == null && currentNode.right == null) {
				int sum = 0;
				for (int num: currentPath) {
					sum += num;
				}
				if (sum == targetSum) {
					res.add(currentPath);
				}
			}

			if (currentNode.right != null) {
				// 将当前路径值放到pathStack队列中
				List<Integer> newPath = new ArrayList<>(currentPath);
				newPath.add(currentNode.right.val);
				nodeStack.push(currentNode.right);
				pathStack.push(newPath);
			}

			if (currentNode.left != null) {
				// 将当前路径值放到pathStack队列中
				List<Integer> newPath = new ArrayList<>(currentPath);
				newPath.add(currentNode.left.val);
				nodeStack.push(currentNode.left);
				pathStack.push(newPath);
			}
		}

		return res;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);

		root.left = node1;
		root.right = node2;

		node1.left = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		node5.left = node8;
		node5.right = node9;

		PathSumTest pathSumTest = new PathSumTest();
		List<List<Integer>> res = pathSumTest.pathSum(root, 22);
		System.out.println(res);
	}

}
