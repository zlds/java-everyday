package org.example.leetcode.repetition;

/**
 * @author: hanchaowei
 * @date 2024/1/2
 * @description:  两个链表的第一个公共节点
 */

public class FindTowPublicListNode {

	/**
	 * 两个链表的第一个公共节点。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode f(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		// 如果两个指针不指向同一个节点，就继续遍历。
		while (p1 != p2) {
			// 如果p1到达了末尾，将p1指向l2的头节点。开始遍历l2
			// 如果p2到达了末尾，将p2指向l1的头节点。开始遍历l1
			// 这样当两个链表的长度不同时，p1和p2也能够在第一个公共节点上相遇。如果没有公共节点，它们会在各自链表的末尾相遇。
			ListNode nextP1 = (p1 == null) ? l2 : p1.next;
			ListNode nextP2 = (p2 == null) ? l1 : p2.next;
			p1 = nextP1;
			p2 = nextP2;
		}
		return p1;
	}

	/**
	 * 两个链表的第一个公共节点。
	 * 缺点：需要两次遍历，时间复杂度为O(m+n)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode e(ListNode l1, ListNode l2) {
		// 获取l1的长度
		int l1Length = getLength(l1);
		// 获取l2的长度
		int l2Length = getLength(l2);
		// 将第一个链表和第二个链表长度设置一致
		while (l1Length > l2Length) {
			// 将指针向前移动，跳过多余的节点
			l1 = l1.next;
			l1Length--;
		}
		while (l2Length > l1Length) {
			// 将指针向前移动，跳过多余的节点
			l2 = l2.next;
			l2Length--;
		}

		// 两个链表同时遍历，如果遇到相同的节点，就是第一个公共节点
		while (l1 != null && l2 != null) {
			if (l1 == l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return null;
	}

	public int getLength(ListNode head) {
		int i = 1;
		while (head != null) {
			head = head.next;
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		ListNode x1 = new ListNode(1);
		ListNode x2 = new ListNode(2);
		ListNode x3 = new ListNode(3);
		ListNode y1 = new ListNode(4);
		ListNode y2 = new ListNode(5);
		ListNode z1 = new ListNode(6);
		ListNode z2 = new ListNode(7);


		x1.next = x2;
		x2.next = x3;

		y1.next = y2;

		z1.next = z2;

		x3.next = z1;
		y2.next = z1;



		ListNode listNode = new FindTowPublicListNode().f(x1, y1);
		while (listNode != null) {
			System.out.println(listNode.value);
			listNode = listNode.next;
		}

		ListNode listNode1 = new FindTowPublicListNode().e(x1, y1);
		while (listNode1 != null) {
			System.out.println(listNode1.value);
			listNode1 = listNode1.next;
		}
	}

}
