/*
 * Remove Duplicates From Sorted Array - given a sorted array of integers, remove any
 * duplicate numbers from the array. The solution should be placed in the given array,
 * and removal should be done in-place. Given that there will be k elements left after
 * the removals, these elements should be placed in the first k elements of nums. It
 * does not matter what remains after these k elements. Return k.
 * 
 * We can use a 2 pointer approach. We will have a pointer to refer to our place in our
 * solution list (in the first k elements of nums), and another pointer to refer to our 
 * place in the given array. We iterate through nums, skipping over duplicate numbers. 
 * When we find a unique number, it is placed at the next position in our solution list,
 * and we increment our counter variable.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int current = 0;
        int k = 0;
        
        while (current < nums.length) {
            nums[i] = nums[current];
            k++;
            
            while (current < nums.length && nums[current] == nums[i]) {
                current++;
            }
            i++;
        }
        
        return k;
    }
}