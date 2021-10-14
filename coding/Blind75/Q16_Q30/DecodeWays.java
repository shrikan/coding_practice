package Blind75.Q16_Q30;

/*
 * Solution to: 24. https://leetcode.com/problems/decode-ways/
 * 
 * Typical approach of Dynamic Programming of overlapping calculations.
 * Solved through book keeping.
 * 
 * For individual digits, it is continuation of previous way.
 * If 1 or 2with next digit lesser than 7 is found, we can use 2 digits,
 * it adds one additional way. 
 */
public class DecodeWays {
	// Time complexity: O(n), Space compleixty: O(n) 
	public int numDecodings(String s) {
		if (s.charAt(0) == '0')
			return 0;

		int len = s.length(), ways[] = new int[len];
		ways[len] = 1;
		ways[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				ways[i] = 0;
			else if (s.charAt(i) == '1')
				ways[i] = ways[i + 1] + ways[i + 2];
			else if (s.charAt(i) == '2' && s.charAt(i + 1) < '7')
				ways[i] = ways[i + 1] + ways[i + 2];
			else
				ways[i] = ways[i + 1];
		}
		return ways[0];
	}

	public static void main(String[] args) {
		DecodeWays solution = new DecodeWays();
		System.out.println(solution.numDecodings("601"));
		System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
	}
}
