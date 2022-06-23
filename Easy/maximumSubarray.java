/*
 * Maximum Subarray - Given an array of positive and negative integers, determine the sum of the
 * subarray with the highest sum.
 * 
 * We can use a special algorithm called Kadane's algorithm. We traverse the array, adding each element
 * to our sum, and updating the max sum as we go. If the sum ever becomes negative, we can just change
 * it to 0, because a sum of 0 will always be greater than a negative sum.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int length = nums.length;
        
        for (int i = 0; i < length; i++)
        {
            sum += nums[i];
            max = Math.max(sum, max);
            
            if (sum < 0)
                sum = 0;
        }
        
        return max;
    }
}