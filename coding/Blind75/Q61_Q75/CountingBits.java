package Blind75.Q61_Q75;

/*
 * Solution to: 67. https://leetcode.com/problems/counting-bits/
 * 
 * Can solve with DP. Since tthe pattern of bit appearance repeats with every power of 2
 * and bit for number which is power of 2 is 1, we ccan construct it with DP.
 * The patterns repeat for every previous power of 2 number of times. So access that number, 
 * add additional 1 for new power of 2. 
 */
public class CountingBits {
	// Time complexity: O(n)
	public int[] countBits(int n) {
		int res[] = new int[n + 1], power = 1;
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & i - 1) == 0) {
				res[i] = 1;
				power = i;
			} else {
				res[i] = 1 + res[i - power];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		CountingBits solution = new CountingBits();
		int res[] = solution.countBits(5);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
