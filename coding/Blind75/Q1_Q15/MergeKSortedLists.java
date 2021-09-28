package Blind75.Q1_Q15;

import Commons.ListNode;

/*
 * Solution to: 9. https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length < 1)
			return null;
		ListNode temp = lists[0];
		int beginIndex = 0;
		while (temp == null && beginIndex < lists.length - 1) {
			temp = lists[++beginIndex];
		}
		if (temp == null)
			return null;
		ListNode head = temp;
		while (temp.next != null)
			temp = temp.next;
		for (int i = beginIndex + 1; i < lists.length - 1; i++) {
			temp.next = lists[i];
			while (temp.next != null) {
				temp = temp.next;
			}
		}
		if (beginIndex < lists.length - 1) {
			temp.next = lists[lists.length - 1];
			head = mergeSort(head);
		}
		return head;
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;

		int mid = len(head) / 2, counter = 0;
		ListNode left = head;
		while (counter < mid - 1) {
			head = head.next;
			counter++;
		}
		ListNode right = head.next;
		head.next = null;
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		ListNode head = left, prev = null;
		while (left != null && right != null) {
			if (left.val > right.val) {
				if (prev == null) {
					head = right;
					right = right.next;
					head.next = left;
					prev = head;
				} else {
					prev.next = right;
					prev = right;
					right = right.next;
					prev.next = left;
				}
			} else {
				prev = left;
				left = left.next;
			}
		}
		if (right != null)
			prev.next = right;
		return head;
	}

	private int len(ListNode head) {
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}

	public static void main(String[] args) {
		MergeKSortedLists solution = new MergeKSortedLists();
		ListNode root1 = new ListNode(1, new ListNode(4, new ListNode(5)));
//		ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode root3 = new ListNode(0, new ListNode(2));
		ListNode lists[] = { root1, root3 };// , root2, root3 };
		ListNode root = solution.mergeKLists(lists);
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
	}
}
