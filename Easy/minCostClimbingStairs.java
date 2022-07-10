/*
 * Min Cost Climbing Stairs - Given an array of integers representing the cost of step on a staircase,
 * find the minimum cost to reach the top of the stairs. When you pay the cost of a step, you can
 * move up one or two steps.
 * 
 * This is a dynammic programming problem. We use an array to keep track of the minimum prices
 * for moving forward one step and two steps. At the end, the last element in our array will have
 * the minimum cost.
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        
        return dp[len];
    }
}