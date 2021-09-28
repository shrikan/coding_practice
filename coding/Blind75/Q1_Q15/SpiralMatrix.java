package Blind75.Q1_Q15;

import java.util.ArrayList;
import java.util.List;

/* 
 * Solution to: 15. https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		return spiralOrderUtility(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, new ArrayList<Integer>());
	}

	private List<Integer> spiralOrderUtility(int[][] matrix, int left, int right, int top, int down,
			ArrayList<Integer> result) {
		if (left > right || top > down) {
			return result;
		}
		if (left == right && top == down) {
			result.add(matrix[left][right]);
			return result;
		}
		for (int i = left; i < right; i++)
			result.add(matrix[top][i]);
		for (int i = top; i < down; i++)
			result.add(matrix[i][right]);
		if (top != down)
			for (int i = right; i > left; i--)
				result.add(matrix[down][i]);
		else
			result.add(matrix[top][right]);
		if (left != right)
			for (int i = down; i > top; i--)
				result.add(matrix[i][left]);
		else
			result.add(matrix[down][right]);
		return spiralOrderUtility(matrix, left + 1, right - 1, top + 1, down - 1, result);
	}

	public static void main(String[] args) {
		SpiralMatrix solution = new SpiralMatrix();
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//		int matrix[][] = { { 6 ,  9 ,  7 } };
		List<Integer> res = solution.spiralOrder(matrix);
		for (Integer num : res) {
			System.out.print(num + " ");
		}
	}
}