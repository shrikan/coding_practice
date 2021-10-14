package Blind75.Q46_Q60;

/*
 * Solution to: 46. https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
	boolean isWord;
	Trie letters[];

	public Trie() {
		letters = new Trie[26];
	}

	public void insert(String word) {
		Trie temp = this;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (temp.letters[idx] == null) {
				temp.letters[idx] = new Trie();
			}
			temp = temp.letters[idx];
		}
		temp.isWord = true;
	}

	public boolean search(String word) {
		Trie temp = this;
		for (char c : word.toCharArray()) {
			if (temp.letters[c - 'a'] == null)
				return false;
			temp = temp.letters[c - 'a'];
		}
		return temp.isWord;
	}

	public boolean startsWith(String prefix) {
		Trie temp = this;
		for (char c : prefix.toCharArray()) {
			if (temp.letters[c - 'a'] == null)
				return false;
			temp = temp.letters[c - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // True
		System.out.println(trie.search("app")); // False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app")); // return True

	}
}
