/*
 * Problem: BestTimeToBuyAndSellStocks
 * Difficulty: Easy
 * Topic: Arrays
 * Pattern: Greedy-Approach
 *
 * Approach:
 * iteration over elements looking for price less than the price at which we bought the stocks.
 * when price less then buy encountred, buy the stocks.
 * When price is more than buy check how much profit can be made.
 * Store the highest profit to return it.
 *
 * Time:  O(n)
 * Space: O(1)
 * 
 */

class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int buy = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (buy > price) {
                buy = price;
            } else {
                profit = Math.max(profit, price - buy);
            }
        }
        return profit;
    }

}