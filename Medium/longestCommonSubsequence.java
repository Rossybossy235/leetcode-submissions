/*
 * Longest Common Subsequence - Given two strings, find the size of their longest common subsequence.
 * 
 * We use dynamic programming. We use a matrix that keeps track of longest common subsequence sizes
 * for each combination of i and j. If the characters are equal, then the LCS for i and j would be
 * 1 plus the previous LCS. Otherwise, we take the larger LCS if we skip a character from one of the
 * strings.
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}