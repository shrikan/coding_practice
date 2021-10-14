package Blind75.Q61_Q75;

/*
 * Solution to: 75. https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubStrings {
	public int countSubstrings(String s) {
		int result = 0, len = s.length();
		char[] chars = s.toCharArray();
		for (int i = 0; i < len; i++) {
			result += 1 + getPal(i - 1, i + 1, chars, len) + getPal(i, i + 1, chars, len);
		}
		return result;
	}

	private int getPal(int l, int r, char[] chars, int len) {
		int res = 0;
		while (l >= 0 && r < len) {
			if (chars[l] == chars[r])
				res++;
			else
				break;
			l--;
			r++;
		}
		return res;
	}

	public static void main(String[] args) {
		PalindromicSubStrings solution = new PalindromicSubStrings();
		System.out.println(solution.countSubstrings("abcd"));
	}
}
