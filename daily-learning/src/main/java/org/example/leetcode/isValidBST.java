package org.example.leetcode;


/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description: 判断是否是二叉搜索树
 */
public class isValidBST {
	// 中序遍历时使用。用于记录上一个节点的值。
	private static TreeNode prev;

	public static class TreeNode {
		// 当前节点的值
		int val;
		// 左子树
		TreeNode left;
		// 右子树
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * 检查是否是二叉树
	 * @param root
	 * @return
	 */
	public static boolean isValidTreeNode(TreeNode root) {
		// 中序遍历实现
		prev = null;
		return inOrder(root);
//		return isValidTreeNode(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	/**
	 * 私有辅助函数
	 * @param node
	 * @param minVal
	 * @param maxVal
	 * @return
	 */
	private static boolean isValidTreeNode(TreeNode node,long minVal, long maxVal) {
		if (node == null) {
			return true;
		}
		// 递归遍历
		// 左子树的所有节点的值都应该小于根节点的值，而右子树的所有节点的值都应该大于根节点的值
		if (node.val <= minVal || node.val >= maxVal) {
			return false;
		}
		// 左子树小于根节点，右子树大于根节点
		return isValidTreeNode(node.left,minVal,node.val) && isValidTreeNode(node.right,node.val,maxVal);
	}

	/**
	 * 中序遍历(通过中序遍历的特性来判断是否是二叉树)
	 * @param node
	 * @return
	 */
	private  static boolean inOrder(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (!inOrder(node.left)) {
			return false;
		}
		// 如果当前节点小于上一个节点表示不是二叉搜索树(中序是升序的)
		if (prev != null && node.val <= prev.val) {
			return false;
		}
		prev = node;
		return inOrder(node.right);
	}


	public static void main(String[] args) {
		// 正确的二叉树
		TreeNode validBST = new TreeNode(3);
		validBST.left = new TreeNode(1);
		validBST.right = new TreeNode(5);
		validBST.right.left = new TreeNode(4);
		validBST.right.right = new TreeNode(6);

		// 错误的二叉树
		TreeNode invalidBST = new TreeNode(5);
		invalidBST.left = new TreeNode(1);
		invalidBST.right = new TreeNode(4);
		invalidBST.right.left = new TreeNode(3);
		invalidBST.right.right = new TreeNode(6);

		// true
		System.out.println(isValidTreeNode(validBST));
		// false
		System.out.println(isValidTreeNode(invalidBST));
	}

}
