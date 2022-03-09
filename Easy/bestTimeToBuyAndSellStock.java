class Solution {
    public int maxProfit(int[] prices) {
        
        int least = Integer.MAX_VALUE;
        int profit = 0;
        int profitToday = 0;
        
        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < least)
                least = prices[i];
            
            profitToday = prices[i] - least;
            
            if (profit < profitToday)
            {
                profit = profitToday;
            }
        }
        
        return profit;
    }
}