/*
 * Valid Palindrome - Given a string, determine whether it is a valid palindrome, ignoring
 * case, punctuation, and white space.
 * 
 * We can use two pointers, one at the beginning and one at the end. We loop through the 
 * string, using built-in functions to skip over whitespace and punctuation. If the 
 * two pointers' letters do not match, we return false. If we make it to the end, then
 * it is a palindrome.
 */

class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.isEmpty())
            return true;
        
        int current1 = 0;
        int current2 = s.length() - 1;
        
        while (current1 <= current2) {
            char c1 = s.charAt(current1);
            char c2 = s.charAt(current2);
            
            if (!Character.isLetterOrDigit(c1))
                current1++;
            else if (!Character.isLetterOrDigit(c2))
                current2--;
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2))
                    return false;
                current1++;
                current2--;
            }
        }
        
        return true;
    }
}