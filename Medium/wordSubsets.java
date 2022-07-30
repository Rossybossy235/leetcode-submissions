/*
 * Word Subsets - Given two lists of strings, return a list of strings where words2 is a subset of 
 * words1. A string is a subset if all the letters are used exactly once.
 * 
 * First, we get a count of all the letters in words2. Then, we look at all the strings in words1, 
 * placing strings into our results list if the letters in words2 are all used in the current string.
 * We use a helper function to count the letters in the strings.
 */

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> res = new ArrayList<>();
        int[] counts = new int[26];
        int[] current;
        int i;
        
        for (String str : words2) {
            current = getCount(str);
            
            for (i = 0; i < 26; i++) {
                counts[i] = Math.max(counts[i], current[i]);
            }
        }
        
        for (String str : words1) {
            current = getCount(str);
            
            for (i = 0; i < 26; i++) {
                if (current[i] < counts[i])
                    break;
            }
            
            if (i == 26)
                    res.add(str);
        }
        
        return res;
    }
    
    public int[] getCount(String s) {
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        return count;
    }
}