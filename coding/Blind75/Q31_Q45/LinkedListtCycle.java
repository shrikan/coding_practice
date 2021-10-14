package Blind75.Q31_Q45;

import Commons.ListNode;

/*
 * Solution to: 36. https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListtCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast = head.next.next;
		head = head.next;
		while (fast != null && fast.next != null) {
			if (fast == head)
				return true;
			fast = fast.next.next;
			head = head.next;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedListtCycle solution = new LinkedListtCycle();
		ListNode head = new ListNode(3);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(0);
		ListNode last = new ListNode(-4, second);

		head.next = second;
		second.next = third;
		third.next = last;
		System.out.println(solution.hasCycle(head));
	}
}
