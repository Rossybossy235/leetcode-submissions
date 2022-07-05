/*
 * Longest Consecutive Sequence - Given an unsorted array of integers, return the length of the longest
 * consecutive elements sequence (i.e. 1,2,3,4 or 4,5,6,7... etc).
 * 
 * We start by placing all elements into a hash set. Then, we iterate through the set. Every time
 * the current number - 1 is not in the set, it is the start of a new consecutive sequence. We look
 * forward until we reach the end of the sequence, where the next number is not in the set, and update
 * our results variable, which holds the length of the largest consecutive sequence.
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                
                while (set.contains(next)) {
                    next++;
                }
                
                res = Math.max(res, next - num);
            }
        }
        
        return res;
    }
}