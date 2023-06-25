package org.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/6/24
 * @description: 广度优先
 */

public class BFS {

	public static List<List<Integer>> levelOrder(TreeNode root) {

		// 返回结果
		List<List<Integer>> levels = new ArrayList<List<Integer>>();

		if (root == null) {
			return levels;
		}

		// 创建队列，将根节点添加到队列中。队列遵循先进先出的原则
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			// 创建一个新的列表来存储当前层次的元素值
			List<Integer> levelList = new ArrayList<Integer>();
			// 遍历队列
			int levelLength = queue.size();
			for (int i = 0; i < levelLength; i++) {
				// 取出元素
				TreeNode node = queue.remove();
				// 将元素值添加到当前层次的列表中
				levelList.add(node.val);

				// 如果左节点不为空添加到队列中
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			// 将当前层的处理结果添加到总的层次列表中
			levels.add(levelList);
		}
		return levels;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> lists = levelOrder(root);
		System.out.println(lists);
	}

}

