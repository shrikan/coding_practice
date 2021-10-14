package Blind75.Q61_Q75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Solution to: 70. https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 
 * Typical dynamic programming with overlapping calculations.
 * Solved through book keeping.
 * 
 * In order for water to reach pacific, the cell should be reachable either to left end
 * or top end. So doing reverse engineering, mark all the cells reachable from left or top.
 * 
 * Similarly, mark all the cells reachable from right or down as reachable to atlantic.
 * 
 * Traverse again through all cells and if a cell is marked both with pacific and atlantic,
 * add the result.
 */
public class PacificAtlanticWaterFlow {
	// Time complexity: O(m*n), Space complexity: O(m*n)
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<>();
		int length = heights.length, breadth = heights[0].length;
		int res[][] = new int[length][breadth];
		for (int j = 0; j < breadth; j++) {
			pacificFlow(heights, 0, j, res);
			atlanticFlow(heights, length - 1, j, res);
		}
		for (int i = 0; i < length; i++) {
			pacificFlow(heights, i, 0, res);
			atlanticFlow(heights, i, breadth - 1, res);
		}
		for (int i = 0; i < length; i++)
			for (int j = 0; j < breadth; j++)
				if (res[i][j] == 3)
					result.add(Arrays.asList(i, j));
		return result;
	}

	private void pacificFlow(int[][] heights, int i, int j, int[][] res) {
		if (i < 0 || j < 0 || i == heights.length || j == heights[0].length || res[i][j] == 1 || res[i][j] == 3)
			return;

		res[i][j]++;
		if (i != heights.length - 1 && heights[i + 1][j] >= heights[i][j])
			pacificFlow(heights, i + 1, j, res);
		if (i != 0 && heights[i - 1][j] >= heights[i][j])
			pacificFlow(heights, i - 1, j, res);
		if (j != heights[0].length - 1 && heights[i][j + 1] >= heights[i][j])
			pacificFlow(heights, i, j + 1, res);
		if (j != 0 && heights[i][j - 1] >= heights[i][j])
			pacificFlow(heights, i, j - 1, res);
	}

	private void atlanticFlow(int[][] heights, int i, int j, int[][] res) {
		if (i < 0 || j < 0 || i == heights.length || j == heights[0].length || res[i][j] == 2 || res[i][j] == 3)
			return;
		res[i][j] += 2;
		if (i != heights.length - 1 && heights[i + 1][j] >= heights[i][j])
			atlanticFlow(heights, i + 1, j, res);
		if (i != 0 && heights[i - 1][j] >= heights[i][j])
			atlanticFlow(heights, i - 1, j, res);
		if (j != heights[0].length - 1 && heights[i][j + 1] >= heights[i][j])
			atlanticFlow(heights, i, j + 1, res);
		if (j != 0 && heights[i][j - 1] >= heights[i][j])
			atlanticFlow(heights, i, j - 1, res);
	}

	public static void main(String[] args) {
		PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
		int heights[][] = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
//		int heights[][] = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		List<List<Integer>> result = solution.pacificAtlantic(heights);
		for (List<Integer> row : result) {
			for (Integer ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}
	}
}
