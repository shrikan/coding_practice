package Blind75.Q31_Q45;

/*
 * Solution to:. 42. https://leetcode.com/problems/house-robber/
 * 
 * Typical Dynamic Programming with overlapping calculations.
 * Solved through book keeping. Keep track of 2 step previous and 3 step previous.
 * Either of these 2 can yield higher result with addition to current.
 */
public class HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length, value[] = new int[len];
		if (len == 1)
			return nums[0];
		if (len == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		}
		value[len - 1] = nums[len - 1];
		value[len - 2] = nums[len - 2];
		int result = value[len - 1] > value[len - 2] ? value[len - 1] : value[len - 2];
		for (int i = nums.length - 3; i >= 0; i--) {
			if (i + 3 < len && value[i + 3] > value[i + 2]) {
				value[i] = nums[i] + value[i + 3];
			} else {
				value[i] = nums[i] + value[i + 2];
			}
			if (value[i] > result)
				result = value[i];
		}
		return result;
	}

	public static void main(String[] args) {
		HouseRobber solution = new HouseRobber();
		int nums[] = { 1, 3, 1 };
		System.out.println(solution.rob(nums));
	}
}
