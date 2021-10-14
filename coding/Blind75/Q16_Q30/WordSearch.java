package Blind75.Q16_Q30;

/*
 * Solution to: 23. https://leetcode.com/problems/word-search/
 * 
 * DFS approach: Similar to Number of Islands problem.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (existUtility(board, word.toCharArray(), 0, i, j))
					return true;
		return false;
	}

	private boolean existUtility(char[][] board, char[] word, int wordIndex, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		if (wordIndex == word.length - 1 && board[i][j] == word[wordIndex])
			return true;
		if (board[i][j] == word[wordIndex]) {
			char temp = board[i][j];
			board[i][j] = '\0';
			if (existUtility(board, word, wordIndex + 1, i - 1, j))
				return true;
			if (existUtility(board, word, wordIndex + 1, i, j - 1))
				return true;
			if (existUtility(board, word, wordIndex + 1, i + 1, j))
				return true;
			if (existUtility(board, word, wordIndex + 1, i, j + 1))
				return true;
			board[i][j] = temp;
		}

		return false;
	}

	public static void main(String[] args) {
		WordSearch solution = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "S";
		System.out.println(solution.exist(board, word));
	}
}
