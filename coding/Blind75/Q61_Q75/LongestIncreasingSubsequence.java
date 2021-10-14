package Blind75.Q61_Q75;

/*
 * Solution to: 64. https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length, res[] = new int[len], result = 1;
		res[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			res[i] = 1;
			int j = i + 1;
			while (j < len) {
				if (nums[j] > nums[i]) {
					res[i] = ((1 + res[j]) > res[i]) ? res[j] + 1 : res[i];
				}
				j++;
			}
			if (res[i] > result)
				result = res[i];
		}
		return result;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(solution.lengthOfLIS(nums));
	}
}
