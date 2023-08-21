package org.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2023/8/21
 * @description:
 */

public class SerializeTreeNode {

	/**
	 * 序列化
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		if (root == null) {
			return "null,";
		}
		// 前序遍历
		String leftStr = serialize(root.left);
		String rightStr = serialize(root.right);
		return root.val + "," + leftStr + rightStr;
	}

	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserializeHelper(queue);
	}

	/**
	 * 反序列化
	 * @param queue
	 * @return
	 */
	private TreeNode deserializeHelper(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("null")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(value));
		root.left = deserializeHelper(queue);
		root.right = deserializeHelper(queue);
		return root;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;

		SerializeTreeNode serializeTreeNode = new SerializeTreeNode();
		String serialize = serializeTreeNode.serialize(node1);
		System.out.println("序列化: " + serialize);

		// 反序列化
		TreeNode deserialize = serializeTreeNode.deserialize(serialize);
		System.out.println(deserialize.left.val);
	}
}
