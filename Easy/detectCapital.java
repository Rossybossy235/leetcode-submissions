/*
 * Detect Capital - Given a string, determine whether that word uses proper
 * capitalization, i.e. "Yes", "yes", or "YES".
 * 
 * We can use a regular expression. The first is one or more capitals ("YES"), one
 * or more lowercase letters ("yes"), and a capital followed by one or more
 * lowercase letters("Yes"). Remember the + means one or more, the | means or.
 */

class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}