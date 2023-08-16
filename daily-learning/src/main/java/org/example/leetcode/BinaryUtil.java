package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/8/16
 * @description:
 */

public class BinaryUtil {

	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();

			if (currentNode != null) {
				System.out.print(currentNode.val + " ");
				if (currentNode.left != null || currentNode.right != null) {
					queue.add(currentNode.left);
					queue.add(currentNode.right);
				}
			} else {
				System.out.print("null ");
			}
		}
		System.out.println("");
	}

}
