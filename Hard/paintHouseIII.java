/*
 * Paint House III - Check leetcode description, gets complicated.
 * 
 * Hard to say, taken from dicussion. This is a difficult dynammic programming problem.
 */

class Solution {
    
    int MAX = 100000000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int res = rec(houses, cost, m, n, target, 0, 0, -1, dp);
        
        if (res == MAX)
            return -1;
        else
            return res;
    }
    
    public int rec(int[] houses, int[][] cost, int m, int n, int target, 
                  int houseToBePainted, int currentTarget, int lastNbhColor, int[][][] dp) {
        if (houseToBePainted == m) {
            if (currentTarget == target)
                return 0;
            else
                return MAX;
        }
        
        if (currentTarget == target + 1)
            return MAX;
        
        if (lastNbhColor != -1) {
            if (dp[houseToBePainted][lastNbhColor][currentTarget] != -1)
                return dp[houseToBePainted][lastNbhColor][currentTarget];
        }
        
        int minCost = MAX;
        
        for (int curr = 0; curr < n; curr++) {
            boolean isFree = false;
            
            if (houses[houseToBePainted] != 0) {
                if (houses[houseToBePainted] != curr + 1)
                    continue;
                else
                    isFree = true;
            }
            
            if (curr != lastNbhColor) {
                minCost = Math.min(minCost, rec(houses, cost, m, n, target, houseToBePainted + 1, currentTarget + 1, curr, dp) + ((isFree) ? 0 : cost[houseToBePainted][curr]));
            }
            else {
                minCost = Math.min(minCost, rec(houses, cost, m, n, target, houseToBePainted + 1, currentTarget, curr, dp) + ((isFree) ? 0 : cost[houseToBePainted][curr]));
            }
        }
        
        if (lastNbhColor != -1) {
            dp[houseToBePainted][lastNbhColor][currentTarget] = minCost;
        }
        return minCost;
    }
}