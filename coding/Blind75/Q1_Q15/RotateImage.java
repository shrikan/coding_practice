package Blind75.Q1_Q15;

/*
 * Solution to: 12. https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
	// Time Complexity: O(n*n) - n : length/breadth
	public void rotate(int[][] matrix) {
		rotateUtil(matrix, 0, matrix.length - 1);
	}

	private void rotateUtil(int[][] matrix, int start, int end) {
		if (start >= end)
			return;
		for (int i = start; i < end; i++) {
			// right
			int ele = matrix[i][end];
			matrix[i][end] = matrix[start][i];

			// down
			int temp = matrix[end][end - i + start];
			matrix[end][end - i + start] = ele;
			ele = temp;

			// left
			temp = matrix[end - i + start][start];
			matrix[end - i + start][start] = ele;
			ele = temp;

			// up
			matrix[start][i] = ele;
		}
		rotateUtil(matrix, start + 1, end - 1);
	}

	// Easier but same time complexity as the above
	public void rotate1(int[][] matrix) {
		// Take transpose of a matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				if (i != j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}

		// Reverse each row
		for (int i = 0; i < matrix.length; i++) {
			int start = 0, end = matrix.length - 1;
			while (start < end) {
				int temp = matrix[i][end];
				matrix[i][end--] = matrix[i][start];
				matrix[i][start++] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage solution = new RotateImage();
		int img[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int img1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int img[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
//		int img[][]= {{4,8},{3,6}};
//		int img[][] = { { 1 } };
		solution.rotate(img);
		for (int[] row : img) {
			for (int ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
		solution.rotate1(img1);
		for (int[] row : img1) {
			for (int ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
}
