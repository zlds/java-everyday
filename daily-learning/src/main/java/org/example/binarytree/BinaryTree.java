package org.example.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		// 判断节点是否为null，为null说明是新值，生成一课新的节点
		if (node == null) {
			return new TreeNode(value);
		}
		// 判断当前节点是否小于当前节点的值，说明新值应该插入当前节点的左子树。否则就是右子树
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

	// 中序遍历

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


	// 迭代
	public static List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		// 新建栈
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.add(curr.value);
			// 先将右子树入栈,然后是左子树,当从栈中弹出时,左子树会先被处理。(栈是先如后出的)

			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		return result;
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


		List<Integer> integers = preorderTraversalIterative(root);
		System.out.println(integers);
	}
}
