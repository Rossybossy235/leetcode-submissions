/*
 * How Many Numbers Are Smaller Than the Current Number - Given an array of integers, for each
 * number, determine how many numbers in the array are smaller than the current number.
 * 
 * This is a brute force approach. We just use 2 nested for loops to go through the array and count
 * how many numbers are smaller than the current number, and place results into a new array.
 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            
            res[i] = count;
        }
        
        return res;
    }
}