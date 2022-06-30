/*
 * Minimum Moves to Equal Array Elements II - Given an array of integers, find the minimum number of
 * moves required to make all array elements equal. With on emove, you can increment or decrement 
 * one array element.
 * 
 * Since we want the minimum number of moves, we want to find the element that the rest of the elements
 * are closest to. So, we find the median. Then, we iterate through the array, adding the difference
 * between the current element and the median to our count. At the end, the count will hold the 
 * minimum number of moves required to make all the elements equal.
 */

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int median = nums[nums.length / 2];
        int count = 0;
        
        for (int i = 0; i < nums.length; i++)
            count += Math.abs(median - nums[i]);
        
        return count;
    }
}