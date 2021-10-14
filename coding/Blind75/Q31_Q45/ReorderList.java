package Blind75.Q31_Q45;

import Commons.ListNode;

public class ReorderList {
	ListNode secondHead=null;
    public void reorderList(ListNode head) {
        ListNode slow = head, fast=head, curr=head, prev=null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null)
            return;

        prev.next = null;
        reverse(slow);
        
        while(curr.next!=null && secondHead!=null){
            ListNode temp = curr.next;
            curr.next = secondHead;
            secondHead = secondHead.next;
            curr = curr.next;
            curr.next = temp;
            curr = curr.next;
        }
        if(secondHead!=null)
            curr.next = secondHead;
    }
    
    private ListNode reverse(ListNode head){
        if(head.next==null){
            secondHead = head;
            return head;
        }
            
        ListNode temp = reverse(head.next);
        temp.next = head;
        head.next = null;
        return head;
    }

	public static void main(String[] args) {
		ReorderList solution = new ReorderList();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		solution.reorderList(head);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
