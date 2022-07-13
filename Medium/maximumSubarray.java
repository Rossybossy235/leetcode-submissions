/*
 * Maximum Subarray - Given an array of integers, find the sum of the subarray with the highest sum.
 * 
 * This is a very basic dynammic programming problem using Kadane's algorithm. We iterate through the 
 * array, creating a "running max" of the sum of previous elements and the current element. We then 
 * keep track of the largest of these maximums. Whenever the current element is larger than the sum of 
 * previous elements, it means we have started a new, possibly larger, subarray.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}