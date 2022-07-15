/*
 * Find All Anagrams in a String - Given two strings s and p, return a list of the start positions
 * of all anagrams of p in s.
 * 
 * We slide a window of the size of the smaller window. As the window goes, we keep track of the 
 * letters in the window, and we check if the letters in the window are the same as the letters in
 * the smaller string.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        int len = p.length();
        
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++)
            chars[p.charAt(i) - 'a']++;
        
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            m[s.charAt(i) - 'a']++;
            
            if (i >= len - 1) {
                boolean valid = true;
                for (int j = 0; j < 26; j++)
                    if (m[j] != chars[j])
                        valid = false;
                
                if (valid)
                    res.add(i - len + 1);
                
                m[s.charAt(i - len + 1) - 'a']--;
            }
        }
        
        return res;
    }
}