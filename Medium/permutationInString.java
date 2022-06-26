/*
 * Permutation in String - Given two strings, detemine whether a permutation of the first string
 * exists in the second string.
 * 
 * We use an array containing the number of each character we encounter in s1 and s2 and sliding
 * window. When a character is encountered in s1, its count is incremented. When a character is
 * encountered in s2, its count is decremented. We can start by looping through the length of s1,
 * incrementing counts in s1 and decrementing counts in s2. We can do a check here to see if we have
 * solved the problem. We then use a sliding window, with i as the end of the window and
 * i - s1.length() as the beginning of the window. We increment counts at the beginning of the
 * window and decrement counts at the end of the window. With each pass, we check to see if all
 * the counts are 0.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length())
            return false;
        
        int[] count = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        boolean solved = true;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                solved = false;
        }
        
        if (solved == true)
            return true;
        
        solved = true;
        
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            
            for (int j = 0; j < count.length; j++) {
                if (count[j] != 0)
                    solved = false;
            }
            
            if (solved == true)
                return true;
            
            solved = true;
        }
        
        return false;
    }
}