/*
 * Kth Largest Element in an Array - Given an array of integers, find the kth (second, third, etc) 
 * largest element in the array.
 * 
 * This is a brute force approach. We sort the array, then increment a pointer variable to the 
 * position of the element we want, then return that element.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int current = 0;
        
        for (int i = 0; i < nums.length - k; i++)
            current++;
        
        return nums[current];
    }
}