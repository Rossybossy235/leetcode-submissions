/*
 * Non-Decreasing Array - Given an array of integers, determine if the array can be made non-decreasing
 * (i.e. nums[i] <= nums[i + 1]) by modifying only one element.
 * 
 * We use a greedy solution. We iterate through the array, checking if an element needs to be changed.
 * If it does, we take the difference. Then, depending on the difference, we change either the current
 * element or the previous element, and set a flag. If we find another element that needs to be
 * changed, we return false.
 */

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        int previous = Integer.MIN_VALUE;
        
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff < 0) {
                if (flag)
                    return false;
                else
                    flag = true;
                
                if (nums[i] >= previous)
                    nums[i - 1] = previous;
                else
                    nums[i] = nums[i - 1];
            }
            previous = nums[i - 1];
        }
        return true;
    }
}