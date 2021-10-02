package Blind75.Q16_Q30;

/*
 * Solution t: 19. https://leetcode.com/problems/unique-paths/
 * 
 * Classic Dynamic programming approach with overlapping calculations.
 * Solved through book keeping.
 */
public class UniquePaths {
	// Time complexity: O(m*n), Space complexity: O(m*n)
	public int uniquePaths(int m, int n) {
		int pathTable[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			pathTable[i][n - 1] = 1;
		for (int i = 0; i < n; i++)
			pathTable[m - 1][i] = 1;
		int i = m - 2, j = n - 2;
		while (i >= 0 && j >= 0) {
			pathTable[i][j] = pathTable[i + 1][j] + pathTable[i][j + 1];
			if (i == 0 && j == 0) {
				break;
			}
			int surplus = j;
			while (surplus >= 0) {
				pathTable[i][surplus] = pathTable[i + 1][surplus] + pathTable[i][surplus + 1];
				surplus--;
			}
			surplus = i;
			while (surplus >= 0) {
				pathTable[surplus][j] = pathTable[surplus + 1][j] + pathTable[surplus][j + 1];
				surplus--;
			}
			i--;
			j--;
		}
		while (i >= 0 && n > 1) {
			pathTable[i][0] = pathTable[i + 1][0] + pathTable[i][1];
			i--;
		}
		while (j >= 0 && m > 1) {
			pathTable[0][j] = pathTable[1][j] + pathTable[0][j + 1];
			j--;
		}
		return pathTable[0][0];
	}

	public static void main(String[] args) {
		UniquePaths solution = new UniquePaths();
		System.out.println(solution.uniquePaths(3, 2));
	}
}
