package Blind75.Q46_Q60;

/*
 * Solution to: 49. https://leetcode.com/problems/house-robber-ii/
 * 
 * Dynamic programming through book keeping
 * Two traversals:
 * 1. Forward traversal excluding final cell.
 * 2. Reverse traversal excluding first cell.
 * 
 * The maximum in both traversals combined is the final answer.
 */
public class HousrRobberII {
	// Time complexity: O(n)
	public int rob(int[] nums) {
		int len = nums.length, res[] = new int[len];
		if (len == 1)
			return nums[0];
		res[len - 1] = nums[len - 1];
		res[len - 2] = nums[len - 2];
		int i = len - 3;
		int result = res[len - 2] > res[len - 1] ? res[len - 2] : res[len - 1];
		while (i > 0) {
			if (i + 3 < len && res[i + 2] < res[i + 3]) {
				res[i] = nums[i] + res[i + 3];
			} else {
				res[i] = nums[i] + res[i + 2];
			}
			if (res[i] > result)
				result = res[i];
			i--;
		}
		res[0] = nums[0];
		if (res[0] > result)
			result = res[0];
		res[1] = nums[1];
		for (i = 2; i < len - 1; i++) {
			if (i - 3 >= 0 && res[i - 2] < res[i - 3]) {
				res[i] = nums[i] + res[i - 3];
			} else {
				res[i] = nums[i] + res[i - 2];
			}
			if (res[i] > result)
				result = res[i];
		}
		return result;
	}

	public static void main(String[] args) {
		HousrRobberII solution = new HousrRobberII();
		int nums[] = { 4, 1, 2, 7, 5, 3, 1 };
		System.out.println(solution.rob(nums));
	}
}
