package Blind75.Q1_Q15;

/*
 * Solution to: 14. https://leetcode.com/problems/maximum-subarray
 */
public class MaxSubArray {
	// Using Kadane's algorithm
	// Time complexity O(n)
	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = 0;
		for (int ele : nums) {
			if (ele > ele + maxEndingHere) {
				maxEndingHere = ele;
			} else {
				maxEndingHere += ele;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		MaxSubArray solution = new MaxSubArray();
		// int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums = { -2, 1 };
		System.out.println(solution.maxSubArray(nums));
	}
}
