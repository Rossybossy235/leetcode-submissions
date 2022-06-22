/*
 * Valid Anagram - Given two strings, determine whether the second string is an anagram of the first.
 * An anagram is a string formed by rearranging the characters of the string.
 * 
 * We use an array of integers to keep track of the number of characters. When we traverse the first
 * string, we add one for every character. When we traverse the second string, we subtract one for each
 * character. If the array contains all 0s after the traversals, the second string is an anagram of the
 * first.
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < chars.length; i++)
            if (chars[i] != 0)
                return false;
        
        return true;
    }
}