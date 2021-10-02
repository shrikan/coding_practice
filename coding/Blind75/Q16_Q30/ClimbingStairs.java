package Blind75.Q16_Q30;

/*
 * Solution to: 20. https://leetcode.com/problems/climbing-stairs/
 * 
 * Classic Dynamic programming approach with overlapping calculations.
 * Solved through book keeping.
 */
public class ClimbingStairs {
	// Time Complexity: O(n), Space Complexity: O(n)
	public int climbStairs(int n) {
		if (n < 4)
			return n;
		int steps[] = new int[n];
		steps[n - 1] = 1;
		steps[n - 2] = 2;
		int i = n - 3;
		while (i >= 0) {
			steps[i] = steps[i + 1] + steps[i + 2];
			i--;
		}
		return steps[0];
	}

	public static void main(String[] args) {
		ClimbingStairs solution = new ClimbingStairs();
		System.out.println(solution.climbStairs(5));
	}
}
