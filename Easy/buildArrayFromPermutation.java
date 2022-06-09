/*
 * Build Array From Permutation - given an array of a zero-based permutation, i.e. a list
 * containing the unique integers 0-n, not sorted, return an array such that 
 * ans[i] = nums[nums[i]].
 * 
 * The answer is in the description. All we need to do is loop through the given array,
 * and perform the given operation for our results array.
 */

class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        
        return ans;
    }
}