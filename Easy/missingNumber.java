/*
 * Missing Number - Given an array of integers within the range 0 - nums.length, find the one 
 * number missing from the array.
 * 
 * Since there is only one missing number, we can iterate through the array, checking if each number
 * is one greater than the one before it. If we find a number that does not satisfy this, we have
 * found our missing number. If we get through the entire array, then the missing number is either
 * the first number or the last number.
 */

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1)
                return nums[i] - 1;
        }
        
        if (nums[nums.length - 1] == nums.length)
            return 0;
        else
            return nums.length;
    }
}