package org.example.binarytree;

/**
 * @author: hanchaowei
 * @date 2023/4/13
 * @description:
 */

public class BinaryTree {
	public static class TreeNode {
		int value;
		// 左子树
		TreeNode left;
		// 右子树
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static TreeNode insert(TreeNode node,int value) {
		if (node == null) {
			return new TreeNode(value);
		}
		if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		}
		return node;
	}
	/**
	 * 前序遍历
	 * @param node
	 */
	public static void preorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	public static void inorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.value + " ");
		inorderTraversal(node.right);
	}

	/**
	 * 后序遍历
	 * @param node
	 */
	public static void postorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.value + " ");
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("前序遍历");
		preorderTraversal(root);
		System.out.println("中序遍历");
		inorderTraversal(root);
		System.out.println("后续遍历");
		postorderTraversal(root);
	}
}
