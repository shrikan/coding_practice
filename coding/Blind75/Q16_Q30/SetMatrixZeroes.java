package Blind75.Q16_Q30;

import java.util.HashSet;
import java.util.Set;

/*
 * Solution to: 21. https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int totalRows = matrix.length, totalCols = matrix[0].length;
		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}
		for (int i = 0; i < totalRows; i++) {
			boolean zero = false;
			if (rows.contains(i)) {
				zero = true;
			}
			for (int j = 0; j < totalCols; j++) {
				if (zero) {
					matrix[i][j] = 0;
				} else {
					if (i == 0 && columns.contains(j))
						matrix[0][j] = 0;
					else if (i > 0 && matrix[0][j] == 0 && columns.contains(j))
						matrix[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		SetMatrixZeroes solution = new SetMatrixZeroes();
		int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		solution.setZeroes(matrix);
		for (int row[] : matrix) {
			for (int ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}
	}
}
