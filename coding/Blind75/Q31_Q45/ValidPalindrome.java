package Blind75.Q31_Q45;

/*
 * Solution to: 32. https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char chars[] = s.toLowerCase().toCharArray();
		int left = 0, right = chars.length - 1;
		while (left < right) {
			while (left < right && !isAlphaNum(chars[left])) {
				left++;
			}
			while (right > left && !isAlphaNum(chars[right])) {
				right--;
			}
			if (chars[left++] != chars[right--])
				return false;
		}
		return true;
	}

	private boolean isAlphaNum(char c) {
		return (c - 'a' >= 0 && c - 'a' < 26) || (c - '0' >= 0 && c - '0' <= 9);
	}

	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
