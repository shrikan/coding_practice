package Blind75;

import Commons.ListNode;

/*
 * Solution to: 8. https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l2.val < l1.val) {
			l1 = new ListNode(l2.val, l1);
			l2 = l2.next;
		}
		ListNode prev = l1, head = l1;
		l1 = l1.next;
		while (l1 != null && l2 != null) {
			if (l2.val < l1.val) {
				ListNode temp = l2.next;
				prev.next = l2;
				l2.next = l1;
				l2 = temp;
			} else {
				l1 = l1.next;
			}
			prev = prev.next;
		}
		if (l2 != null) {
			prev.next = l2;
		}
		return head;
	}

	public static void main(String[] args) {
		MergeSortedLists solution = new MergeSortedLists();
		ListNode root1 = new ListNode(5);
		ListNode root2 = new ListNode(1, new ListNode(2, new ListNode(4)));

		root1 = solution.mergeTwoLists(root1, root2);
		while (root1 != null) {
			System.out.print(root1.val + "->");
			root1 = root1.next;
		}
	}
}
