package Blind75.Q46_Q60;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	class Trie {
		boolean isEnd = false;
		int max = 0;
		Trie letters[] = new Trie[26];

		public void insert(String word) {
			Trie temp = this;
			if (word.length() > max)
				this.max = word.length();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (temp.letters[c - 'a'] == null)
					temp.letters[c - 'a'] = new Trie();
				temp = temp.letters[c - 'a'];
			}
			temp.isEnd = true;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words)
			trie.insert(word);
		List<String> result = new ArrayList<String>();
		char ca[] = new char[trie.max];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (trie.letters[board[i][j] - 'a'] != null)
					getWords(trie, board, i, j, result, ca, 0);
			}
		}
		return result;
	}

	private void getWords(Trie trie, char[][] board, int i, int j, List<String> result, char[] ca, int k) {
		if (trie.isEnd) {
			result.add(new String(ca, 0, k));
			trie.isEnd = false;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '\0')
			return;
		char c = board[i][j];
		int idx = c - 'a';
		if (trie.letters[idx] != null) {
			board[i][j] = '\0';
			ca[k] = c;
			getWords(trie.letters[idx], board, i + 1, j, result, ca, k + 1);
			getWords(trie.letters[idx], board, i - 1, j, result, ca, k + 1);
			getWords(trie.letters[idx], board, i, j + 1, result, ca, k + 1);
			getWords(trie.letters[idx], board, i, j - 1, result, ca, k + 1);
			ca[k] = '\0';
			board[i][j] = c;
		}
	}

	public static void main(String[] args) {
		WordSearchII solution = new WordSearchII();
		char board[][] = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
//	char board[][] = { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
//			{ 'a', 'f', 'l', 'v' } };
		String words[] = { "oa", "oaa" };
//	String words[] = { "oath", "pea", "eat", "rain" };
		List<String> result = solution.findWords(board, words);
		for (String word : result) {
			System.out.println(word);
		}
	}
}
