package selected;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution to: https://leetcode.com/problems/n-queens/
 * 
 * Famous problem for backtracking
 * 
 * @author shrinidhikanchi
 *
 */
public class NQueens {
	// Solve with the help of backtracking recursive solution
	// Time complexity: O(2^n)
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new LinkedList<List<String>>();
		return getNQueensPossibilities(n, 0, new LinkedList<String>(), result);
	}

	// Helper function to get NQueens
	private List<List<String>> getNQueensPossibilities(int n, int rowNumber, List<String> colList,
			List<List<String>> result) {
		/*
		 * colList : list containing column at which Queen is placed in the row(nothing but the index)
		 * Ex: {2, 4, 1, 3} => 	0th row - 2nd column
		 * 						1st row - 4th column
		 * 						2nd row - 1st column
		 * 						3rd row - 3rd column
		 * 
		 * Typical backtracking approach:
		 * 		Base condition
		 * 		iterate over 
		 * 			Do something on i
		 * 				Recursive call for next possibility
		 * 			Undo thing on i
		 */
		// 1. Base condition
		if (rowNumber == n) {
			result.add(colList.stream().collect(Collectors.toList()));
			return result;
		}
		// 2. Iterate over
		for (int i = 0; i < n; i++) {
			// Create an entry with . and Q, Ex, ..Q. for n=4 and i=2
			char[] entry = new char[n];
			Arrays.fill(entry, '.');
			entry[i] = 'Q';
			
			// 3. Do something on i
			colList.add(String.valueOf(entry));
			if (isSafe(colList)) {
				// 4. Recursive call 
				result = getNQueensPossibilities(n, rowNumber + 1, colList, result);
			}
			// 5. Undo on i
			colList.remove(colList.size() - 1);
		}
		return result;
	}

	private boolean isSafe(List<String> colList) {
		int currentRow = colList.size() - 1;
		for (int i = 0; i < currentRow; i++) {
			if (colList.get(i).equals(colList.get(currentRow))) {
				return false;
			}
			int leftIndex = colList.get(i).indexOf('Q');
			int currentIndex = colList.get(currentRow).indexOf('Q');
			if (Math.abs(leftIndex - currentIndex) == currentRow - i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens solution = new NQueens();
		int n = 4;
		List<List<String>> result = solution.solveNQueens(n);
		for (List<String> board : result) {
			for (String row : board) {
				System.out.println(row);
			}
			System.out.println();
		}
	}
}
