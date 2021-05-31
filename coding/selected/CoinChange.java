package selected;

import java.util.Arrays;

/**
 * Solution to: https://leetcode.com/problems/coin-change/
 * 
 * @author shrinidhikanchi
 *
 */
public class CoinChange {
	// Dynamic programming approach
	// Time complexity: O(m*n), where m=amount, n=number of coins
	public int coinChange(int[] coins, int amount) {
		int[] resultTable = new int[amount + 1];

		// Initialise the array with invalid amount
		Arrays.fill(resultTable, Integer.MAX_VALUE - 1);

		resultTable[0] = 0; // coins for amount 0 is 0.
		Arrays.sort(coins);

		for (int i = coins[0]; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					resultTable[i] = Integer.min(resultTable[i], resultTable[i - coin] + 1);
				}
			}
		}
		return resultTable[amount] > amount ? -1 : resultTable[amount];
	}

	public static void main(String[] args) {
		CoinChange solution = new CoinChange();
		/*
		 * [186,419,83,408] 6249
		 */
		int[] arr = { 1, 2, 5};
		System.out.println(solution.coinChange(arr, 11));
	}
}
