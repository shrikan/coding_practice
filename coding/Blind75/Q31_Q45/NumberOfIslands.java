package Blind75.Q31_Q45;

/*
 * Solution to: 43. https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1') {
					result++;
					connectedLand(grid, i, j);
				}
		}
		return result;
	}

	private void connectedLand(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
			return;
		grid[i][j]='0';
		connectedLand(grid, i + 1, j);
		connectedLand(grid, i - 1, j);
		connectedLand(grid, i, j + 1);
		connectedLand(grid, i, j - 1);
	}

	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		char[][] grid = { { '1', '1', '1', '1' }, { '0', '0', '0', '0' }, { '0', '0', '0', '1' },
				{ '0', '1', '1', '1' } };
		System.out.println(solution.numIslands(grid));
	}
}
