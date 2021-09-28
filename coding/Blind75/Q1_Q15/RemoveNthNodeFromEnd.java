package Blind75.Q1_Q15;

import Commons.ListNode;

/*
 * Solution to: 6. https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tail = head, curr = head;
		for (int i = 0; i < n; i++) {
			tail = tail.next;
		}
		if (tail == null) {
			return head.next;
		}
		while (tail.next != null) {
			tail = tail.next;
			curr = curr.next;
		}
		curr.next = curr.next.next;

		return head;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEnd sollution = new RemoveNthNodeFromEnd();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		head = sollution.removeNthFromEnd(head, 4);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
