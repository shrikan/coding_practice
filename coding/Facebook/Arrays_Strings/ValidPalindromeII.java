package Facebook.Arrays_Strings;

/*
 * Solution to: https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		return validPalindromeUtil(s, 0, s.length() - 1, 0);
	}

	public boolean validPalindromeUtil(String s, int left, int right, int buffer) {
		if (buffer > 1)
			return false;
		if (left >= right) {
			return true;
		}
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}
		if (left >= right)
			return true;
		boolean valid = validPalindromeUtil(s, left, right - 1, buffer + 1);
		if (!valid)
			return validPalindromeUtil(s, left + 1, right, buffer + 1);
		return valid;
	}

	public static void main(String[] args) {
		ValidPalindromeII solution = new ValidPalindromeII();
		String s = "aba";

		System.out.println(solution.validPalindrome(s));
	}
}
