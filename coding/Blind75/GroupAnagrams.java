package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Solution to: 13. https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			List<String> temp = anagrams.getOrDefault(key, new ArrayList<String>());
			temp.add(str);
			anagrams.put(key, temp);
		}
		return new ArrayList<List<String>>(anagrams.values());
	}

	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = solution.groupAnagrams(strs);
		for (List<String> words : ans) {
			for (String word : words) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
}
