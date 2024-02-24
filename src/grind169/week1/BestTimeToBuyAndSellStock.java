package grind169.week1;

public class BestTimeToBuyAndSellStock {
    /*
     *  Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
     *
     *  Test Cases:
     *    [7,1,5,3,6,4] -> 5 (6-1)
     *    [7,6,4,3,1] -> 0
     */

    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int lowestPrice = prices[0];
            for(int price : prices) {
                int currProfit = price - lowestPrice;
                maxProfit = Math.max(currProfit, maxProfit);
                lowestPrice = Math.min(price, lowestPrice);
            }
            return maxProfit;
        }
    }
}
