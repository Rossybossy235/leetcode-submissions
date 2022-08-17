/*
 * Unique Morse Code Words - Given a list of strings, convert them into morse code, and return the
 * number of unique morse codes that are formed from the words. All morse codes for each letter are
 * given.
 * 
 * We can use a hash set, and place each word's morse code into it. Since a key can only be placed
 * once, the set will only contain the unique morse codes. Once finished, we simply return the size
 * of the set.
 */

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                                      "....","..",".---","-.-",".-..","--","-.",
                                      "---",".--.","--.-",".-.","...","-","..-",
                                      "...-",".--","-..-","-.--","--.."};
        
        Set<String> seen = new HashSet<>();
        
        for (String word : words) {
            StringBuilder curr = new StringBuilder();
            
            for (char c : word.toCharArray()) {
                curr.append(codes[c - 'a']);
            }
            
            seen.add(curr.toString());
        }
        
        return seen.size();
    }
}