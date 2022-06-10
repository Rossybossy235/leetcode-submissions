/*
 * Reverse String - Given an array of characters representing a string, reverse the array.
 * 
 * This is a two pointers problem, one at the beginning of the array, and one at the end. We
 * iterate from both ends of the string, swapping characters as we go, incrementing our left
 * pointer, and decrementing our right pointer.
 */

class Solution {
    public void reverseString(char[] s) {
        
        int current1 = 0;
        int current2 = s.length - 1;
        
        // swap characters
        while (current1 < current2) {
            char temp = s[current1];
            s[current1] = s[current2];
            s[current2] = temp;
            
            current1++;
            current2--;
        }
    }
}