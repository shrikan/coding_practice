package selected;

/*
 * Solution to: https://leetcode.com/problems/maximum-sum-circular-subarray/
 * 
 * Two part solution: 
 * 1. Normal Kadane's algorithm to check 'maxSubArray' for straight array
 * 2. For circular array sum, add all array elements, subtract array sum with 'minSubArray'
 * 
 * If all elements are negative, then should return maxSubArray 
 * Else, return max of these two values.
 */
public class MaximumCircularSubArray {
	// Time Complexity: O(n), Space complexity: O(1)
	public int maxSubarraySumCircular(int[] A) {
		int maxEndingHere = 0, maxSum = Integer.MIN_VALUE, arraySum = 0;
		int minEndingHere = 0, minSum = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			int ele = A[i];
			maxEndingHere += ele;
			minEndingHere += ele;
			arraySum += ele;

			maxSum = (maxSum < maxEndingHere) ? maxEndingHere : maxSum;
			minSum = (minSum > minEndingHere) ? minEndingHere : minSum;
			maxEndingHere = (maxEndingHere < 0) ? 0 : maxEndingHere;
			minEndingHere = (minEndingHere > 0) ? 0 : minEndingHere;
		}
		if (arraySum == minSum)
			return maxSum;
		return Math.max(maxSum, arraySum - minSum);
	}

	public static void main(String[] args) {
		MaximumCircularSubArray solution = new MaximumCircularSubArray();
		int nums[] = { 1, -2, 3, -2 };
		System.out.println(solution.maxSubarraySumCircular(nums));
	}
}
