package org.example.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/8/16
 * @description: 合并二叉树
 */

public class MergeTowBinary {


	/**
	 * 递归合并二叉树
	 * @param node1
	 * @param node2
	 * @return
	 */
	public TreeNode mergeBinary(TreeNode node1,TreeNode node2) {

		if (node1 == null && node2 == null) {
			return null;
		}

		// 如果其中一个节点为空，返回另一个节点
		if (node1 == null) {
			return node2;
		}

		if (node2 == null) {
			return node1;
		}

		// 合并当前节点
		TreeNode merged = new TreeNode(node1.val + node2.val);
		// 递归合并左子树
		merged.left = mergeBinary(node1.left, node2.left);
		// 递归合并右子树
		merged.right = mergeBinary(node1.right, node2.right);

		return merged;
	}


	/**
	 * 迭代合并二叉树
	 * @param node1
	 * @param node2
	 * @return
	 */
	public TreeNode mergeTowBinary(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null) {
			return node2;
		}

		if (node2 == null) {
			return node1;
		}

		// 创建队列
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.add(node1);
		queue2.add(node2);

		while (!queue1.isEmpty()) {
			// 取出当前节点
			TreeNode currentNode1 = queue1.poll();
			TreeNode currentNode2 = queue2.poll();

			// 合并当前节点
			currentNode1.val += currentNode2.val;

			// 如果第一棵树当前左子树为null,但第二棵树不为null,则将第二棵树的左子树赋值给第一棵树。
			if (currentNode1.left == null && currentNode2.left != null) {
				currentNode1.left = currentNode2.left;
			} else if (currentNode1.left != null && currentNode2.left != null) {
				queue1.add(currentNode1.left);
				queue2.add(currentNode2.left);
			}
			// 如果第二棵树当前右子树为null,但第二课树不为null,则将第二课树的右子树赋值给第一个树。
			if (currentNode1.right == null && currentNode2.right != null) {
				currentNode1.right = currentNode2.right;
			} else if (currentNode1.right != null && currentNode2.right != null) {
				queue1.add(currentNode1.right);
				queue2.add(currentNode2.right);
			}
		}
		return node1;
	}

	public static void main(String[] args) {
		MergeTowBinary mergeTowBinary = new MergeTowBinary();
		// 构建第一棵树 root1 = [1,3,2,5]
		TreeNode x1 = new TreeNode(1);
		TreeNode x2 = new TreeNode(2);
		TreeNode x3 = new TreeNode(3);
		TreeNode x4 = new TreeNode(5);
		x1.left = x3;
		x1.right = x2;
		x3.left = x4;

		// 构建第二棵树 root2 = [2,1,3,null,4,null,7]
		TreeNode y1 = new TreeNode(2);
		TreeNode y2 = new TreeNode(1);
		TreeNode y3 = new TreeNode(3);
		TreeNode y4 = new TreeNode(4);
		TreeNode y5 = new TreeNode(7);
		y1.left = y2;
		y1.right = y3;
		y2.right = y4;
		y3.right = y5;

		TreeNode result1 = mergeTowBinary.mergeBinary(x1, y1);
		BinaryUtil.printTree(result1);
		System.out.println("非递归方法合并");
		TreeNode result2 = mergeTowBinary.mergeTowBinary(x1, y1);
		BinaryUtil.printTree(result2);
	}

}
