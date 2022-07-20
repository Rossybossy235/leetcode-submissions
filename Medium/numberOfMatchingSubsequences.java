/*
 * Number of Matching Subsequences - Given a string s and a list of strings, return the number of
 * strings in the list that are subsequences of s.
 * 
 * We use a mix of hash map and two pointers. We place each string into a hash map, along with the
 * number of times that string appears in the list (this makes it so we can skip duplicates). Then,
 * for every string in the hash map, we check if it is a subsequence of s using two pointers. 
 * If the current letters are the same, we move our pointer in the current string forward until we
 * find a new letter. Then, we move the pointer in s forward until the letters are the same again.
 * If we reach the end of either string, we stop iterating and check if the second pointer is equal
 * to the length of the current string. If it is, then the current string is a subsequence, and we
 * add the number of times the string appears to our results variable.
 */

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        for (String sequence : map.keySet()) {
            int i = 0;
            int j = 0;
            int len = sequence.length();
            
            while (i < s.length() && j < len) {
                if (s.charAt(i) == sequence.charAt(j))
                    j++;
                i++;
            }
            
            if (j == len)
                res += map.get(sequence);
        }
        
        return res;
    }
}