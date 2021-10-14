package Blind75.Q46_Q60;

/*
 * Solution : 60. https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int len = nums.length, sum = len * (len + 1) / 2;
		for (int num : nums) {
			sum -= num;
		}
		return sum;
	}

	public static void main(String[] args) {
		MissingNumber solution = new MissingNumber();
		int nums[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println(solution.missingNumber(nums));
	}
}
