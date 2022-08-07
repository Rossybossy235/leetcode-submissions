/*
 * Count Vowels Permutation - Given an integer representing the length of a possible string, return
 * the number of possible permutations using only vowels. There are restrictions as to what letters
 * can come after others, look at the leetcode problem for the restrictions.
 * 
 * We use bottom up dynammic programming. dp represents the number of valid permutations that end in
 * a certain letter. Our final answer is the sum of elements in previous.
 */

class Solution {
    public int countVowelPermutation(int n) {
        long[] dp = new long[5];
        long[] previous = new long[5];
        int mod = (int) (1e9 + 7);
        
        Arrays.fill(previous, 1L);
        
        while (n-- > 1) {
            dp[0] = (previous[1] + previous[2] + previous[4]) % mod;
            dp[1] = (previous[0] + previous[2]) % mod;
            dp[2] = (previous[1] + previous[3]) % mod;
            dp[3] = previous[2];
            dp[4] = (previous[2] + previous[3]) % mod;
            
            long[] temp = dp;
            dp = previous;
            previous = temp;
        }
        
        return (int) ((previous[0] + previous[1] + previous[2] + previous[3] + previous[4]) % mod);
    }
}