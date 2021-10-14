package Blind75.Q61_Q75;

/* 
 * Solution to: 71. https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * Sliding window problem. At every step, move right index and check if
 * the window-maxFreq of characters is in the range of k. If not, move left index
 * till it gets all right.
 */
public class LongestRepeatingCharacterReplace {
	public int characterReplacement(String s, int k) {
		int startIndex = 0, window = 0, endIndex = 0, len = s.length(), charCount[] = new int[26];
		int maxFreq = 0, result = 0;
		char chars[] = s.toCharArray();
		while (endIndex < len) {
			window++;
			int indx = chars[endIndex] - 'A';
			charCount[indx]++;
			if (charCount[indx] > maxFreq)
				maxFreq = charCount[indx];
			while (window - maxFreq > k) {
				indx = chars[startIndex] - 'A';
				charCount[indx]--;
				window--;
				startIndex++;
			}
			endIndex++;
			if (window > result) {
				result = window;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplace solution = new LongestRepeatingCharacterReplace();
		System.out.println(solution.characterReplacement("ABBB", 2));
	}
}
