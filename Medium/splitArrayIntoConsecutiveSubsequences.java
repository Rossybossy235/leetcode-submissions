/*
 * Split Array into Consecutive Subsequences - Given an array of integers, determine whether the array
 * can be split into at least 2 subsequences such that each subsequence's numbers are exactly one
 * greater than the previous and all subsequences have a length of 3 or more.
 * 
 * We iterate through the array to get the frequencies of all the elements. Then, we iterate through 
 * the array again and we see if each element can be appended to a previously made consecutive sequence,
 * or if it can be the start of a new sequence. If neither of those can be done, then we return false.
 * Otherwise, at the end, we return true.
 */

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> appendCounts = new HashMap<>();
        
        for (int n : nums)
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        
        for (int n : nums) {
            if (counts.get(n) == 0)
                continue;
            else if (appendCounts.getOrDefault(n, 0) > 0) {
                appendCounts.put(n, appendCounts.get(n) - 1);
                appendCounts.put(n + 1, appendCounts.getOrDefault(n + 1, 0) + 1);
            }
            else if (counts.getOrDefault(n + 1, 0) > 0 && counts.getOrDefault(n + 2, 0) > 0) {
                counts.put(n + 1, counts.get(n + 1) - 1);
                counts.put(n + 2, counts.get(n + 2) - 1);
                appendCounts.put(n + 3, appendCounts.getOrDefault(n + 3, 0) + 1);
            }
            else
                return false;
            
            counts.put(n, counts.get(n) - 1);
        }
        
        return true;
    }
}