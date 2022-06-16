/*
 * How Many Numbers Are Smaller Than the Current Number - Given an array of integers, for each
 * number, determine how many numbers in the array are smaller than the current number.
 * 
 * We take the running sum of the counts of each number. We iterate through the list, placing
 * the counts of each number into an array. We then iterate over the new array, replacing each
 * index with the running sum of the counts. We then iterate over nums again, placing the number
 * of smaller numbers into a results array.
 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts = new int[101];
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        
        for (int i = 1; i <= 100; i++) {
            counts[i] += counts[i - 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = counts[nums[i] - 1];
        }
        
        return res;
    }
}