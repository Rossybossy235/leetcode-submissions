/*
 * Out Of Boundary Paths - Look at leetcode's description, difficult to word.
 * 
 * 
 */

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0)
            return 0;
        
        int[][] dp = new int[m + 2][n + 2];
        int[][] prev = new int[m + 2][n + 2];
        
        for (int i = 1; i <= m; i++) {
            dp[i][n]++;
            dp[i][1]++;
        }
        
        for (int i = 1; i <= n; i++) {
            dp[1][i]++;
            dp[m][i]++;
        }
        
        int res = dp[startRow + 1][startColumn + 1];
        
        for (int i = 1; i < maxMove; i++) {
            int[][] temp = dp;
            dp = prev;
            prev = temp;
            
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    dp[j][k] = (int)(((long) prev[j - 1][k] + prev[j + 1][k] + prev[j][k - 1] + prev[j][k + 1]) % 1000000007L);
                }
            }
            res = (res + dp[startRow + 1][startColumn + 1]) % 1000000007;
        }
        
        return res;
    }
}