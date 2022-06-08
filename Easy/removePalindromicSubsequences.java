/*
 * Remove Palindromic Subsequences - Given a string, return the minimum number of 
 * palidromic subsequences to remove in order to make the string empty.
 * 
 * The key here is that we remove palidromic SUBSEQUENCES. The palidromes can have other letters
 * within them. Another key for this problem is that the string can only contain 'a' and 'b'.
 * This means that in the worst case, only two palidromic subsequences need to be removed.
 * For example, the string "abaabaaaab" has quite a few palidromes. However, "aaaaaaa" and
 * "bbb" are considered palidromic subsequences, so we can remove those. In the best case, the
 * entire string is a palidrome, so we can just remove the entire string.
 * 
 * So we can use the two pointer approach. We start from either end of the string, checking
 * if the letters are the same. If we iterate through the entire string and no letters are
 * different, then the entire string is a palindrome, and we can return 1.
 * If at any point the letters do not match, then we return 2.
 */

class Solution {
    public int removePalindromeSub(String s) {
        int current1 = 0;
        int current2 = s.length() - 1;
        
        while (current1 <= current2) {
            if (s.charAt(current1) == s.charAt(current2)) {
                current1++;
                current2--;
            }
            else {
                return 2;
            }
        }
        
        return 1;
    }
}