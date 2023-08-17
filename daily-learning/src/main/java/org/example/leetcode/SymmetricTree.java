package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/17
 * @description: 对称二叉树
 */

public class SymmetricTree {


	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left,root.right);
	}


	public boolean isMirror(TreeNode left, TreeNode right) {

		// 如果两个节点都为null,返回true
		if (left == null && right == null) {
			return true;
		}
		// 如果其中一个为null返回false
		if (left == null || right == null) {
			return false;
		}

		return (left.val == right.val)
				&& isMirror(left.left, right.right)
				&& isMirror(left.right, right.left);

	}


	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode1 = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(3);
		TreeNode treeNode5 = new TreeNode(4);
		TreeNode treeNode6 = new TreeNode(4);

		treeNode.left = treeNode1;
		treeNode.right = treeNode2;

		treeNode1.left = treeNode3;
		treeNode1.right = treeNode5;

		treeNode2.left = treeNode6;
		treeNode2.right = treeNode4;

		SymmetricTree symmetricTree = new SymmetricTree();
		System.out.println(symmetricTree.isSymmetric(treeNode));
	}


}
