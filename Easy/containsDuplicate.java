/*
 * Contains Duplicate - Given a list of integers, determine whether the list contains duplicate
 * numbers.
 * 
 * We iterate through the list, placing unique values into a hash map. If we encounter a value that
 * is already in the hash map, then the list contains duplicates.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            
            map.put(nums[i], true);
        }
        
        return false;
    }
}