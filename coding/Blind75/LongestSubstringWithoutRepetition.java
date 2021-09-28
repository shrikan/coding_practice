package Blind75;

import java.util.HashMap;

/*
 * Solution to: 2. https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepetition {
	public int lengthOfLongestSubstring(String s) {
		int longest = -1, startIndex = 0;
		HashMap<Character, Integer> charMap = new HashMap<>();
		int currIndex = 0;

		while (currIndex < s.length()) {
			char c = s.charAt(currIndex);
			if (charMap.getOrDefault(c, -1) >= startIndex) {
				if ((currIndex - startIndex) > longest) {
					longest = (currIndex - startIndex);
				}
				int charIndex = charMap.get(c);
				startIndex = charIndex + 1;
			}
			charMap.put(c, currIndex);
			currIndex++;
		}
		return ((currIndex - startIndex) > longest) ? (currIndex - startIndex) : longest;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepetition solution = new LongestSubstringWithoutRepetition();
		System.out.println(solution.lengthOfLongestSubstring("advdf"));
	}
}
