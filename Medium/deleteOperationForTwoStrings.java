/*
 * Delete Operation For Two Strings - Given two strings, determine the minimum number of character 
 * deletions it will take to make the strings equal.
 * 
 * We use dynamic programming to find the longest common subsequence of the two strings. We use a 
 * matrix that keeps track of longest common subsequence sizes for each combination of i and j. If 
 * the characters are equal, then the LCS for i and j would be 1 plus the previous LCS. Otherwise,
 * we take the larger LCS if we skip a character from one of the strings. Then we add up the lengths
 * of the strings, and subtract 2 * the length of the longest common subsequence, and we have the
 * minimum number of operations needed.
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return word1.length() + word2.length() - (2 * dp[word1.length()][word2.length()]);
    }
}