package org.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/6/28
 * @description: 找出每一层最右边的TreeNode
 */

public class RightSideViewTest {


	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		// 创建队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			res.add(queue.peek().val);
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current.right != null) {
					queue.offer(current.right);
				}
				if (current.left != null) {
					queue.offer(current.left);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);

		List<Integer> res = rightSideView(root);
		System.out.println(res);
	}
}
