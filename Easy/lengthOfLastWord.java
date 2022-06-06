/*
 * Length of Last Word - Given a string, return the last word i.e. the last sequence of
 * letters separated by whitespace.
 * 
 * First we convert the string into an array of characters. Then, we can use a pointer set
 * to the back of the list, and count the number of letters before we encounter white space.
 * However, we must first skip over any whitespace at the back of the list, after the last
 * word.
 */

class Solution {
    public int lengthOfLastWord(String s) {
        char[] str = s.toCharArray();
        
        int i = str.length - 1;
        int length = 0;
        char c = str[i];
        
        if (c == ' ') {
            while (c == ' ' && i >= 0) {
                i--;
                if (i >= 0)
                    c = str[i];
            }
        }
        
        while (c != ' ' && i >= 0) {
            length++;
            i--;
            if (i >= 0)
                c = str[i];
        }
        
        return length;
    }
}