/*
 * Longest Palindrome - Given a string s, find the length of the longest palindrome that can
 * be made using characters from the string.
 * 
 * We use a greedy approach. We first place the counts of each character into an array. Then, since
 * a palindrome must use an even number of each character, we add the number / 2 * 2 into our result.
 * Then, if the current result is an even number, we check if there is one more instance of the
 * current letter. If there is one more instance, that means there can be a unique center, so we add
 * one more to the result.
 */

class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        int res = 0;

        for (char c: s.toCharArray()) {
            counts[c]++;
        }

        for (int n: counts) {
            res += n / 2 * 2;

            if (res % 2 == 0 && n % 2 == 1)
                res++;
        }

        return res;
    }
}