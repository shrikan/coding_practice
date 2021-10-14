package Blind75.Q61_Q75;

public class MedianFinder {
	class ListNode {
		public int val;
		public ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	ListNode head;
	int len;

	/** initialize your data structure here. */
	public MedianFinder() {
		len = 0;
	}

	public void addNum(int num) {
		ListNode temp = head, prev = null;
		while (temp != null) {
			if (temp.val >= num) {
				if (prev == null)
					head = new ListNode(num, head);
				else
					prev.next = new ListNode(num, temp);
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		if (prev == null)
			head = new ListNode(num);
		else
			prev.next = new ListNode(num);
	}

	public double findMedian() {
		if (head == null)
			return 0;
		ListNode slow = head, fast = head;
		int prev = 0;
		while (fast != null) {
			if (fast.next == null) {
				return slow.val;
			}
			prev = slow.val;
			slow = slow.next;
			fast = fast.next.next;
		}
		return (prev + slow.val) / 2.0;
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1); // arr = [1]
		medianFinder.addNum(2); // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3); // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian()); // return 2.0

	}
}
