package Blind75.Q61_Q75;

import java.util.Arrays;

/*
 * Solution to: 65. https://leetcode.com/problems/coin-change/
 * 
 * Classic and most asked DP problem. Solved through book keeping.
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int res[] = new int[amount + 1];
		Arrays.fill(res, Integer.MAX_VALUE-1);
		res[0] = 0;
		for (int coin : coins) {
			if (coin <= amount) {
				res[coin] = 1;
				for (int i = coin + 1; i <= amount; i++) {
					if (res[i - coin] + 1 < res[i])
						res[i] = res[i - coin] + 1;
				}
			}
		}
		return res[amount]>amount?-1:res[amount];
	}

	public static void main(String[] args) {
		CoinChange solution = new CoinChange();
		int coins[] = { 2, 5 }, amount = 3;
		System.out.println(solution.coinChange(coins, amount));
	}
}
