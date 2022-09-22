/*
 * Length of the Longest Alphabetical Continuous Substring - Given a string, return the length of
 * the longest alphabetical continuous substring. An alphabetical continuous substring is a string
 * of characters such that each character is one letter after the previous in the alphabet.
 * 
 * We simply iterate through the string, checking if the previous letter comes one before the current
 * letter in the alphabet. We keep track of the maximum length, resetting our counter if the current
 * letter is not alphabetically continuous.
 */

class Solution {
    public int longestContinuousSubstring(String s) {
        int max = 1;
        
        int current = 1;
        int currentMax = 1;
        while (current < s.length()) {
            if (s.charAt(current - 1) == s.charAt(current) - 1) {
                currentMax++;
                
                if (currentMax > max)
                    max = currentMax;
            }
            else
                currentMax = 1;
            
            current++;
        }
        
        return max;
    }
}