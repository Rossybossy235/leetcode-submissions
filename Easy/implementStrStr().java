/*
 * Implement strStr() - given two strings, a needle and a haystack, return the starting
 * index of the needle if it exists in the haystack.
 * 
 * We can simply iterate over the string, checking if the substring of our current position
 * plus the length of the needle equals the needle. If it does, then we have our index, and
 * we return i. If we can't find the needle, then we return -1;
 */
class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.equals("")) 
            return 0;
        
        int len = needle.length();
        
        for(int i = 0; i <= haystack.length() - len; i++) 
            if(haystack.substring(i, i + len).equals(needle)) 
                return i;
        
        return -1;

    }
}