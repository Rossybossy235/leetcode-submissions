/*
 * Majority Element - Given an array of integers, determine the number that appears in the majority
 * of the list, i.e. more than length / 2 elements have that number.
 * 
 * We can use a special and simple algorithm (see problem solution, very good explanation). We iterate
 * through the array, if our count is 0, then the current maxNum become the current element. If we 
 * encounter the current maxNum, we increment count, if we encounter any other number, we decrement
 * count.
 */

class Solution {
    public int majorityElement(int[] nums) {
        
        int maxNum = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                maxNum = nums[i];
            }
            
            if (nums[i] == maxNum) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }
        
        return maxNum;
    }
}