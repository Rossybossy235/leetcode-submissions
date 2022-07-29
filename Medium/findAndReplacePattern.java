/*
 * Find And Replace Pattern - Given a list of strings and a pattern string, return a list of the strings
 * that follow the pattern. A string follows the pattern if same letters can be replaced by another 
 * same letter to equal the pattern (acc follows the pattern bdd, one letter followed by 2 of the same
 * letter).
 * 
 * This is an interesting solution from the discussion on this problem, but it did not come with an 
 * explanation.
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (checkPattern(words[i], pattern))
                res.add(words[i]);
        }
        
        return res;
    }
    
    public boolean checkPattern(String s, String pattern) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != pattern.indexOf(pattern.charAt(i)))
                return false;
        }
        
        return true;
    }
}