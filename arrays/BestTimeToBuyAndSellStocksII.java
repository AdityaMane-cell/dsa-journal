/*
 * Problem: Best Time To Buy And Sell Stocks II
 * Difficulty: Medium
 * Topic: Arrays
 * Pattern: Greedy-Approach
 *
 * Approach:
 * iteration over elements looking for price less than the price at which we bought the stocks.
 * when price less then buy encountred, buy the stocks. 
 * if price is more then sell the stock and add the profit amount to net profit
 * and set buying price equal to current stock(multiple sell and buy allowed on same day, given that we hold only one stock).
 * then continue to check the other elements in above manner.
 *
 * Time:  O(n)
 * Space: O(1)
 * 
 */

public class BestTimeToBuyAndSellStocksII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int buy = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (buy > price) {
                buy = price;
            } else {
                profit += price - buy;
                buy = price;
            }
        }
        return profit;
    }
}
