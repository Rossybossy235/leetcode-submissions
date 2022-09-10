/*
 * Group Anagrams - Given an array of strings, group the anagrams together in a list. An anagram
 * is a word or phrase that can be formed by rearranging the letter of a different word or phrase.
 * 
 * We use a hashmap to store unique anagrams along with a list of all the occurences of the anagram.
 * We iterate through all the strings, creating new lists in the map when we encounter a unique
 * anagram. When we find an anagram we've seen before, we simply add the current string to its
 * respective list. At the end, we place the values in the map into a list, and return it.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            
            if (!map.containsKey(String.valueOf(chars)))
                map.put(String.valueOf(chars), new ArrayList<String>());
            map.get(String.valueOf(chars)).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}