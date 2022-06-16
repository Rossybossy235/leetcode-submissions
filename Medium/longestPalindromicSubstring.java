/*
 * Longest Palindromic Substring - Given a string, return the longest palindromic substring in s.
 * 
 * We use dynamic programming. We use an array of booleans to keep track of previous checked
 * substrings as we iterate over all possible substrings. Since, when we check a new substring, we
 * are looking at the previous substring with one character added on, we can determine if it is
 * a palindrome by checking the first and last characters, and by checking if the previous
 * subtring was a palindrome. If the current subtring is a palindrome, we check if it is larger
 * than max. If it is, we update max and set the starting index to the current one.
 */

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[1001][1001];
        int len = s.length();
        int max = 1;
        int start = 0;
        
        for (int i = len; i > 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && (j - i + 1 <= 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i - 1;
                    }
                }
            }
        }
        
        return s.substring(start, start + max);
    }
}