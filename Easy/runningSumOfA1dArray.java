/*
 * Running Sum of a 1d Array - given an array of integers, return the sums of integers as you
 * move through the list. The running sum of [1, 2, 3, 4] would be [1, 3, 6, 10].
 * 
 * We can use a simple for loop, adding up the sums as we go, placing them into a new array.
 */

class Solution {
    public int[] runningSum(int[] nums) {
        
        int sum = 0;
        int[] sums = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        
        return sums;
    }
}