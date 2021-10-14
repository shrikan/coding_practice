package Blind75.Q61_Q75;

/* 
 * Solution to: 69. https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Similar to logic add gate,
 * sum bit: 	a^b
 * carry bit:	a&b
 * 
 * Set the carry bit and left shift it to shift by a bit(coz carry)
 */
public class SumOf2Integers {
	public int getSum(int a, int b) {
		int carry = 0, allOnes = Integer.MAX_VALUE;
		while (b != 0) {
			carry = (a & b);
			a = (a ^ b);
			b = ((carry & allOnes) << 1);
		}
		return a;
	}

	public static void main(String[] args) {
		SumOf2Integers solution = new SumOf2Integers();
		System.out.println(solution.getSum(6, 6));
	}
}
