package org.example.leetcode;


/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description: 判断是否是二叉搜索树
 */
public class isValidBST {
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
		return isValidTreeNode(root,Long.MIN_VALUE,Long.MAX_VALUE);
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
		// 当前节点的值小于最小值或者大于最大值，返回false
		if (node.val <= minVal || node.val >= maxVal) {
			return false;
		}
		return isValidTreeNode(node.left,minVal,node.val) && isValidTreeNode(node.right,node.val,maxVal);
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
