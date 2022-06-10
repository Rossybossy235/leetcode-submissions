/*
 * Longest Substring Without Repeating Characters - Given a string, determine the length
 * of the longest substring that does not contain repeated characters.
 * 
 * We use the sliding window approach. We loop through the string, adding new characters and
 * their indexes into a hash map, incrementing our current length. When we encounter a character 
 * that is already in the hash map, we subtract that character and all the characters to the left
 * of it within our window from the current length.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int max = 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) >= (i - len)) {
                len -= map.get(s.charAt(i)) - (i - len);
            }
            len++;
            
            if (len > max)
                max = len;
            
            map.put(s.charAt(i), i + 1);
        }
        
        return max;
    }
}