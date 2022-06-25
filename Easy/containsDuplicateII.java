/*
 * Contains Duplicate II - Given a list of integers and an integer k, determine whether the list has
 * duplicates where the indices of the duplicates are at most k away from each other.
 * 
 * We iterate through the list, placing unique values and their indices into a hash map. If we 
 * encounter a value that is already in the hash map, we check if the distances between the two
 * duplicates are at most k distance away from each other.
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                if (i - map.get(nums[i]) <= k)
                    return true;
            
            map.put(nums[i], i);
        }
        
        return false;
    }
}