package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/8/20
 * @description: 二叉树的最近公共祖先
 */

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null || node == p || node == q) {
			return node;
		}
		TreeNode left = lowestCommonAncestor(node.left, p, q);
		TreeNode right = lowestCommonAncestor(node.right, p, q);
		// 如果左右节点不等于null，说明找到了p和q
		if (left != null && right != null) {
			return node;
		}
		// 如果只有left返回了一个非null的值，而right返回了null，那么表示p和q都在左子树。所以最近的公共祖先是在左侧
		if (left != null) {
			return left;
		}
		// 如果只有right返回了非null值，而left返回了null，那么表示p和q都在右子树。所以最近的公共祖先是在右侧
		if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;

		LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
		TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(node1, node2, node3);
		System.out.println(treeNode.val);
	}
}
