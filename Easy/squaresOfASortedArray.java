/*
 * Squares Of a Sorted Array - Given an array of integers, return the sorted array of
 * the squares of the given array.
 * 
 * We simply loop through the array, placing the squares into a new array of the 
 * same length, then we sort the new array and return it.
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sq = new int[nums.length];
        
        for (int i = 0; i < sq.length; i++) {
            sq[i] = nums[i] * nums[i];
        }
        
        Arrays.sort(sq);
        return sq;
    }
}