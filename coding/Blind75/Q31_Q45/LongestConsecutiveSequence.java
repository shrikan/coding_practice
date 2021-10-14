package Blind75.Q31_Q45;

import java.util.PriorityQueue;

/*
 * Solution to: 31. https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Another solution would be to use HashSet and check if next element exists.
 * Note: Element fetching is O(1) in HashSet
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		if (len == 0 || len == 1)
			return len;
		PriorityQueue<Integer> numQue = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
		for (int i = 0; i < len; i++)
			numQue.offer(nums[i]);
		int result = 1, prev = numQue.poll(), counter = 1;
		while (!numQue.isEmpty()) {
			int temp = numQue.poll();
			if (temp - prev == 1) {
				counter++;
			} else if (temp - prev > 1)
				counter = 1;
			prev = temp;
			if (counter > result)
				result = counter;
		}
		return result;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
		int nums[] = { 1, 2, 0, 1 };
		System.out.println(solution.longestConsecutive(nums));
	}
}
