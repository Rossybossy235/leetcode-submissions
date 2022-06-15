/*
 * Longest String Chain - Given an array of Strings, determine the length of the longest possible
 * word chain. A word chain is a sequence of strings where each consecutive string in the chain
 * has one letter added to it, while keeping the relative order of characters in the previous
 * string the same.
 * 
 * We use dynamic programming. For each word, we check if its length - the length of the next largest
 * word is 1, which means only one character needs to be added. We also do a function call to check
 * whether the smaller string is contained in the larger one. We then store the current largest word
 * chain, and we return it at the end.
 */

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int[] dp = new int[1001];
        int max = 1;
        int n = words.length;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (words[j - 1].length() - words[i - 1].length() == 1 && checkStr(words[i - 1], words[j - 1])) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[i] + 1);
        }
        
        return max;
    }
    
    private boolean checkStr(String w1, String w2) {
        
        int j = 0;
        for (int i = 0; i < w2.length(); i++) {
            if (j < w1.length() && w2.charAt(i) == w1.charAt(j))
                j++;
        }
        
        if (j < w1.length())
            return false;
        return true;
    }
}