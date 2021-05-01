package selected;

/**
 * Solution to: https://leetcode.com/problems/number-of-islands/description/
 * 
 * @author shrinidhikanchi
 *
 */
public class NumberOfIslands {
	// DFS approach.
	// Time complexity O(m*n), Auxiliary space complexity O(m*n)
	public int numIslands(char[][] grid) {
		int numOfIslands = 0, h = grid.length, w = grid[0].length;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (grid[i][j] == '1') {
					numOfIslands++;
					connectedLands(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}

	private void connectedLands(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		connectedLands(grid, i - 1, j);
		connectedLands(grid, i + 1, j);
		connectedLands(grid, i, j - 1);
		connectedLands(grid, i, j + 1);
	}

	public static void main(String[] args) {
		NumberOfIslands s = new NumberOfIslands();
		char[][] grid = {{'1','1','1','1'},
				{'0','0','0','0'},
				{'0','0','0','1'},
				{'0','1','1','1'}};
		System.out.println(s.numIslands(grid));
	}
}
