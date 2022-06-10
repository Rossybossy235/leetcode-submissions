/*
 * Reverse Words In a String III - Given a string, reverse every word while keeping whitespace
 * and relative positioning of words the same.
 * 
 * We use two pointers. We first iterate our left pointer to find the beginning of a word, then we
 * move our right pointer over to find the end of that word, and set a marker on the end of the word.
 * Then we swap all the characters in that word, and move our left pointer to the marker on the
 * end of that word, and begin looking for the next word. We do this until we have traversed the
 * entire string.
 */

class Solution {
    public String reverseWords(String s) {
        
        char[] str = s.toCharArray();
        int current1 = 0;
        int current2 = 0;
        int endOfWord = 0;
        
        if (s.length() < 2)
            return s;
        
        while (current1 < str.length) {
            while (str[current1] == ' ')
                current1++;
            
            current2 = current1;
            
            while (current2 < str.length - 1 && str[current2] != ' ')
                current2++;
            
            if (str[current2] == ' ')
                current2--;
            
            endOfWord = current2;
            
            while (current1 < current2) {
                char temp = str[current1];
                str[current1] = str[current2];
                str[current2] = temp;
                
                current1++;
                current2--;
            }
            
            current1 = endOfWord + 1;
        }
        
        s = String.valueOf(str);
        return s;
    }
}