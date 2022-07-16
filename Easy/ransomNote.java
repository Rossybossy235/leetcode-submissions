/*
 * Ransom Note - Given two strings, determine if ransomNote can be constructed using the letters 
 * from magazine. Letters in magazine can only be used once.
 * 
 * We use an array to keep track of the letters in magazine, then iterate through ransomNote, checking
 * if the required letters are available.
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (chars[ransomNote.charAt(i) - 'a'] == 0)
                return false;
            chars[ransomNote.charAt(i) - 'a']--;
        }
        
        return true;
    }
}