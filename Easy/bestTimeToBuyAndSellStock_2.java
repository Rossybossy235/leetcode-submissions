/*
 * Best Time To Buy and Sell Stock - Given an array of integers representing the price of a certain
 * stock on a given day, find the maximum profit you can make by buying a stock and selling it later.
 * 
 * We keep track of the current lowest price, and as we go through the array, we check if selling on
 * that particular day will give a higher profit than previously.
 */

class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            
            max = Math.max(max, prices[i] - min);
        }
        
        return max;
    }
}