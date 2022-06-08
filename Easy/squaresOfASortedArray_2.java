/*
 * Squares Of a Sorted Array - Given an array of integers, return the sorted array of
 * the squares of the given array.
 * 
 * In this approach, we use two pointers, one at the beginning and one at the end.
 * We make a new array to hold our squares. We then iterate for the length of the array,
 * checking the absolute value of numbers to determine which one to place into the sorted
 * array.
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sq = new int[nums.length];
        int current1 = 0;
        int current2 = nums.length - 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[current1]) > Math.abs(nums[current2])) {
                sq[i] = nums[current1] * nums[current1];
                current1++;
            }
            else {
                sq[i] = nums[current2] * nums[current2];
                current2--;
            }
        }
        
        return sq;
    }
}