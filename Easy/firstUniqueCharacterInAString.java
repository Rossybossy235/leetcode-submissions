/*
 * First Unique Character in a String - Given a string, find the first character in the string that
 * is not repeated (it only appears once).
 * 
 * We use a hash map. We iterate through the string, placign the character and the number of times it
 * appears in the map. We can update the counts of characters already in the map using .getOrDefault.
 * Then, we iterate through the string again, and return the first character that has a count of 1.
 */

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}