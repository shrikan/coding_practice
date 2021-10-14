package Blind75.Q31_Q45;

/*
 * Solution to: 41. https://leetcode.com/problems/number-of-1-bits/
 * 
 * With bitwise& of n with n-1, the rightmost set bit will be unset.
 * We can continue till number becomes zero.
 * 
 * Another solution: Use >>> operator(Java specific), which is logical right shift, 
 * it does not care about signed bit.
 * Ex,
 * 1111111101 >>1  := 111111110
 * 1111111101 >>>1 := 011111110 
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
		int result = 0;
		while (n != 0) {
			result++;
			n = n & (n - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		Numberof1Bits solution = new Numberof1Bits();
		System.out.println(solution.hammingWeight(3));
	}
}
