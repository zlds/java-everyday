package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/6/26
 * @description: 深度优先
 */

public class DFS {

	static List<Integer> result = new ArrayList<>();

	public static List<Integer> dfs(TreeNode root) {

		if (root == null) {
			return result;
		}
		// 规则: 根节点->左子节点->右子节点。
		result.add(root.val);
		dfs(root.left);
		dfs(root.right);
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(dfs(root));
	}
}
