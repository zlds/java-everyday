package org.example.leetcode.repetition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2024/1/8
 * @description: 判断链表是否是回文链表
 */

public class IsPalindromeListNode {

	public boolean isPalindrome(ListNode head) {
		List<Integer> vals = new ArrayList<>();

		// 将链表复制到数组中
		ListNode currentNode = head;
		while (currentNode != null) {
			vals.add(currentNode.value);
			currentNode = currentNode.next;
		}

		// 使用双指针判断是否回文
		int front = 0;
		int back = vals.size() - 1;
		while (front < back) {
			// 比较值是否相等
			if (!vals.get(front).equals(vals.get(back))) {
				return false;
			}
			front++;
			back--;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		IsPalindromeListNode isPalindRomeListNode = new IsPalindromeListNode();
		boolean palindrome = isPalindRomeListNode.isPalindrome(l1);
		System.out.println(palindrome);

	}

}
