/*
 * Concatenation Of Array - given an array of integers, create a new array of double
 * length that is the concatenation of two of the given arrays.
 * 
 * First we create an array twice the length of nums, then we loop through nums,
 * placing each value into ans[i] and ans[i + nums.length].
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[2 * length];
        
        for (int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[i + length] = nums[i];
        }
        
        return ans;
    }
}