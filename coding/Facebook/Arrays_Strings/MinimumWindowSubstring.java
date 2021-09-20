package Facebook.Arrays_Strings;

/*
 * Solution to: https://leetcode.com/problems/minimum-window-substring/
 * 
 * Create an array for all ascii characters and increment corresponding counts from t
 * Keep two pointers for s, keep traversing 'right' till all characters are covered, 
 * Then try moving 'left' till all characters remain covered. Then move again right 
 * and left similarly till right reaches end and left reaches point where all are covered.
 */
public class MinimumWindowSubstring {
	// Time complexity: O(n), Space complexity: O(constant)
	public String minWindow(String s, String t) {
		int[] lettCount = new int[128];
		String res = "";
		int count = 0;
		for (char c : t.toCharArray()) {
			lettCount[c]++;
		}
		int left = 0, minWin = Integer.MAX_VALUE;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (--lettCount[c] >= 0)
				count++;
			while (count == t.length()) {
				if (minWin > right - left + 1) {
					minWin = right - left + 1;
					res = s.substring(left, right + 1);
				}
				if (++lettCount[s.charAt(left)] > 0) {
					count--;
				}

				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring solution = new MinimumWindowSubstring();
		String s = "aa", t = "aa";
		System.out.println(solution.minWindow(s, t));
	}
}
