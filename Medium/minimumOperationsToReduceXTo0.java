/*
 * Minimum Operations To Reduce X To 0 - Given an array of integers and an integer x, determine the
 * minimum number of operations to reduce x to zero. An operation is subtracting x by a number from 
 * either end of the list. Using a list element for an operation removes that element for future
 * operations.
 * 
 * We use sliding window. First, we iterate through the list to find the sum of all the elements.
 * We then make a target variable which is the sum - x. We want to find the subarray where the sum
 * of those elements equals the target, which would be the point where x would become 0.
 * 
 * So, we iterate through the list. We add the value of the element on the right side of the window
 * to our sum, and increment the right side of our window. Then, if our sum > target, we move the 
 * left side of our window to the right, subtracting elements from our sum. If sum == target, then
 * we have a resulting window, and if it is greater than our current max, we change max. We want the
 * largest window possible, as that will be the window that needs to minimum number of moves. We
 * then return the length of the array - the size of the window, as that is the number of moves
 * needed.
 */

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int current1 = 0;
        int current2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        int target = sum - x;
        sum = 0;
        
        int max = -1;
        
        if (target < 0)
            return -1;
        
        while (current2 < nums.length) {
            sum += nums[current2];
            
            while (sum > target) {
                sum -= nums[current1++];
            }
            
            if (sum == target) {
                if (current2 - current1 + 1 > max) {
                    max = current2 - current1 + 1;
                }
            }
            
            current2++;
        }
        
        if (max == -1)
            return -1;
        else
            return nums.length - max;
    }
}