/*
 * Longest Substring Without Repeating Characters - Given a string, determine the length
 * of the longest substring that does not contain repeated characters.
 * 
 * We use the sliding window approach. We loop through the string, adding new characters and
 * their indexes into an array, incrementing our current length. When we encounter a character 
 * that is already in the array, we subtract that character and all the characters to the left
 * of it within our window from the current length. This solution is more efficient than using
 * a hash map, as indexing an array is easier than looking in a hash map.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int max = 0;
        
        int[] chars = new int[127];
        Arrays.fill(chars, -1);
        
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] >= i - len) {
                len -= chars[s.charAt(i)] - (i - len);
            }
            len++;
            
            if (len > max)
                max = len;
            
            chars[s.charAt(i)] = i + 1;
        }
        
        return max;
    }
}