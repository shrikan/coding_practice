package Blind75.Q61_Q75;

import java.util.Arrays;

/*
 * Solution to: 72. https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * Sort the intervals based on first value. If new element starts with previous range,
 * either of them has to be deleted, so increment the counter. If new element
 * has smaller range, that should be kept, else previous element.
 */
public class NonOverlappingIntervals {
	// Time complexity: O(n logn), n=> a*b, a=>heightt, b=> widht of matrix
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int result = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				result++;
				if (intervals[i][1] > intervals[i - 1][1]) {
					intervals[i][1] = intervals[i - 1][1];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals solution = new NonOverlappingIntervals();
		int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(solution.eraseOverlapIntervals(intervals));
	}
}
