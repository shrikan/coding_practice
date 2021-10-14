package Blind75.Q16_Q30;

/*
 * Solution to: 30. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyAndSellStocks {
	// Time complexity: O(n)
	public int maxProfit(int[] prices) {
		int result = 0, min = prices[0];
		for (int price : prices) {
			if (price < min) {
				min = price;
			}
			int temp = price - min;
			if (temp > result)
				result = temp;
		}
		return result;
	}

	public static void main(String[] args) {
		BestTimetoBuyAndSellStocks solution = new BestTimetoBuyAndSellStocks();
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(solution.maxProfit(prices));
	}
}
