/*
 * First Missing Positive - Given an array of integers, find the smallest missing positive integer
 * from the list.
 * 
 * We treat the array like a hash map. We loop through the list, setting the index of the element
 * given by the number of the current element we are looking to itself * -1, using the * -1 as a
 * marker telling us that the number is contained in the list size (the answer can only be a
 * number less than or exactly one greater than the size of the list). Then we loop through the list
 * again. If we encounter a positive number, we simply return that number's index in the list.
 * Otherwise, we return list.length + 1.
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) - 1 < nums.length && nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] *= -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
}