package Blind75.Q46_Q60;

/*
 * Solution to: 56. https://leetcode.com/problems/valid-anagram/
 * 
 * Change array to hashmap if s/t consists of unicode characters instead of
 * lowercase letters alone. 
 */
public class ValidAnagrams {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		char letters[] = new char[26];
		for (char c : s.toCharArray())
			letters[c - 'a']++;
		for (char c : t.toCharArray())
			letters[c - 'a']--;
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		ValidAnagrams solution = new ValidAnagrams();
		System.out.println(solution.isAnagram("anagram", "nagaram"));
	}
}
