package Blind75.Q16_Q30;

/*
 * Solution to: 22. https://leetcode.com/problems/minimum-window-substring/
 * 
 * Sliding window approach. Keep a count of letters in t. If all of them are used,
 * try shrinking from left and check if the window still holds. Continue it till
 * right reaches end and left can no more be shrinked.
 */
public class MinimumWindowSubString {
	public String minWindow(String s, String t) {
		int letterCount[] = new int[128];
		for (int i = 0; i < t.length(); i++) {
			int a = t.charAt(i);
			letterCount[a]++;
		}
		int left = 0, count = 0, minWin = Integer.MAX_VALUE;
		String result = "";
		for (int right = 0; right < s.length(); right++) {
			if (--letterCount[s.charAt(right)] >= 0)
				count++;
			while (count == t.length()) {
				if (right - left + 1 < minWin) {
					minWin = right - left + 1;
					result = new String(s.substring(left, right + 1));
				}
				if (++letterCount[s.charAt(left)] > 0)
					count--;
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MinimumWindowSubString solution = new MinimumWindowSubString();
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}
}
