package org.example.leetcode;

/**
 * @author: hanchaowei
 * @date 2023/9/21
 * @description: 列表两数相加
 */

public class ListNodeAddTwo {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 虚拟节点
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		// 进位
		int carry = 0;

		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		// 如果carry大于0，说明还有进位，需要再加一个节点
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNodeAddTwo listNodeAddTwo = new ListNodeAddTwo();
		ListNode x1 = new ListNode(2);
		ListNode x2 = new ListNode(4);
		ListNode x3 = new ListNode(3);
		x1.next = x2;
		x2.next = x3;

		ListNode y1 = new ListNode(5);
		ListNode y2 = new ListNode(6);
		ListNode y3 = new ListNode(4);
		y1.next = y2;
		y2.next = y3;

		ListNode listNode = listNodeAddTwo.addTwoNumbers(x1, y1);
		System.out.println(listNode.val + "" + listNode.next.val + "" +listNode.next.next.val);

	}
}
