package Blind75.Q16_Q30;

/*
 * Solution to: 16. https://leetcode.com/problems/jump-game/
 * 
 * Greedy approach is the best solution with O(n). 
 * 
 * D.P provides the answer but at the cost of O(n^2)
 */
public class JumpGame {
	// Greedy approach. Time Complexity: O(n)
	public boolean canJumpGreedy(int[] nums) {
		int farthest = nums[0];
		for (int i = 1; i < nums.length && i <= farthest && farthest < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
		}
		return farthest >= nums.length - 1;
	}

	// D.P Time complexity: O(n^2)
	public boolean canJump(int[] nums) {
		return canJumpUtil(nums, 0);
	}

	private boolean canJumpUtil(int nums[], int currIndex) {
		if (currIndex == nums.length - 1)
			return true;
		if (currIndex >= nums.length || nums[currIndex] == 0)
			return false;
		for (int i = nums[currIndex]; i > 0; i--) {
			if (canJumpUtil(nums, currIndex + i)) {
				return true;
			}
		}
		nums[currIndex] = 0;
		return false;
	}

	public static void main(String[] args) {
		JumpGame solution = new JumpGame();
//		int nums[] = { 3, 2, 1, 0, 4 };
//		int nums[] = new int[10000], num = 9997;
//		nums[0] = num;
//		for (int i = 1; i < nums.length; i++) {
//			nums[i] = num--;
//		}
		int nums[] = { 1, 0, 0, 4, 5 };
//		nums[9999] = 0;
		System.out.println(solution.canJump(nums));
		System.out.println(solution.canJumpGreedy(nums));
	}
}
