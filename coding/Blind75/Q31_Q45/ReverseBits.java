package Blind75.Q31_Q45;

/*
 * Solution to: 40. https://leetcode.com/problems/reverse-bits/
 * 
 * Right shift the number and left shift the result. At every step, if right most bit is set in 
 * number, set the right most bit in result too. With further m shifts to the right, 
 * it will be pushed 32-m bits to the left in the result.
 */
public class ReverseBits {
	// O(1) : 32 constant iterations irrespective of number
	public int reverseBits(int n) {
		int result = 0;
		// 32 iterations because, 32 bit integer.
		for (int i = 0; i < 32; i++) {
			result = result << 1 | n & 1;
			n >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseBits solution = new ReverseBits();
		System.out.println(solution.reverseBits(-3));
	}
}
