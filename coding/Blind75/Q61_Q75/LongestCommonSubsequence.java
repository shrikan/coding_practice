package Blind75.Q61_Q75;

/*
 * Solution to: 76. https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int len1 = text1.length(), len2 = text2.length(), res[][] = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					res[i][j] = res[i - 1][j - 1] + 1;
				} else {
					res[i][j] = res[i - 1][j] > res[i][j - 1] ? res[i - 1][j] : res[i][j - 1];
				}
			}
		}
		return res[len1][len2];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence solution = new LongestCommonSubsequence();
		System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
	}
}
