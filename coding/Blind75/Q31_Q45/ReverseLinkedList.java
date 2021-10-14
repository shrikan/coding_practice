package Blind75.Q31_Q45;

import Commons.ListNode;

/*
 * Solution to: 44. https://leetcode.com/problems/reverse-linked-list/
 * 
 * Can also be done through recursion, with swapping intuition. 
 * But iterative method is faster and less memory consumption.
 */
public class ReverseLinkedList {
	ListNode headNode = null;

	// Time complexity: O(n)
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, headSoFar = null, current = head;
		while (current != null) {
			prev = headSoFar;
			headSoFar = current;
			current = current.next;
			headSoFar.next = prev;
		}

		return headSoFar;
	}

	public static void main(String[] args) {
		ReverseLinkedList solution = new ReverseLinkedList();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		head = solution.reverseList(head);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
