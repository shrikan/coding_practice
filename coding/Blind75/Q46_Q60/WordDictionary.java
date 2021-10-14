package Blind75.Q46_Q60;

/*
 * Solution to: 47. https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Use Trie data structure to implement this.
 */
public class WordDictionary {
	boolean isEnd;
	WordDictionary letters[];

	/** Initialize your data structure here. */
	public WordDictionary() {
		isEnd = false;
		letters = new WordDictionary[26];
	}

	public void addWord(String word) {
		WordDictionary temp = this;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (temp.letters[idx] == null) {
				temp.letters[idx] = new WordDictionary();
			}
			temp = temp.letters[idx];
		}
		temp.isEnd = true;
	}

	public boolean search(String word) {
		return searchUtil(word, 0, this);
	}

	private boolean searchUtil(String word, int i, WordDictionary dict) {
		if (i == word.length())
			return dict.isEnd;
		if (dict == null) {
			return false;
		}
		char c = word.charAt(i);
		if (c == '.') {
			for (int j = 0; j < 26; j++) {
				if (dict.letters[j] != null && searchUtil(word, i + 1, dict.letters[j]))
					return true;
			}
		} else if (dict.letters[c - 'a'] != null) {
			return searchUtil(word, i + 1, dict.letters[c - 'a']);
		}
		return false;
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		System.out.println(wordDictionary.search("a"));
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}
}
