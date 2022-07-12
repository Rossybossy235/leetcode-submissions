/*
 * Matchsticks To Square - Given an array of integers resenting the length of matchsticks, determine
 * whether all the matchsticks can be made into a square without breaking them.
 * 
 * We use a recursive backtracking solution to keep track of the length of each side of the square,
 * referred to as a "bucket". We check if each side has expected values, then add the current
 * matchstick size to one of the sides.
 */

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int target = 0;
        for (int i = 0; i < matchsticks.length; i++)
            target += matchsticks[i];
        
        if (target % 4 != 0)
            return false;
        
        Arrays.setAll(matchsticks, i -> ~matchsticks[i]);
        Arrays.sort(matchsticks);
        Arrays.setAll(matchsticks, i -> ~matchsticks[i]);
        
        int[] buckets = {0, 0, 0, 0};
        return backtrack(0, target / 4, matchsticks, buckets);
    }
    
    public boolean backtrack(int index, int tar, int[] nums, int[] buckets) {
        if (index >= nums.length) {
            for (int i = 1; i < buckets.length; i++) {
                if (buckets[i] != buckets[i - 1])
                    return false;
            }
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            if (buckets[i] + nums[index] <= tar) {
                for (int j = i - 1; j >= 0; j--) {
                    if (buckets[i] == buckets[j]) {
                        if (++i == 4)
                            return false;
                        break;
                    }
                }
                
                buckets[i] += nums[index];
                
                if (backtrack(index + 1, tar, nums, buckets))
                    return true;
                buckets[i] -= nums[index];
            }
        }
        return false;
    }
}