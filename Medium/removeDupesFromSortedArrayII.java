/*
 * Remove Duplicates From Sorted Array II - Given an array of integers, remove duplicates such that
 * each number can appear no more than twice.
 * 
 * We use a 2 pointer approach. We will have a pointer to refer to our place in our
 * solution list (in the first k elements of nums), and another pointer to refer to our 
 * place in the given array. We iterate through nums, skipping over duplicate numbers. 
 * When we find a unique number, it is placed at the next position in our solution list,
 * and we increment our counter variable. We also check the number directly after the new number.
 * If that number is the same, then we also place that into our solution list, moving our pointers
 * accordingly.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int current1 = 0;
        int current2 = 0;
        int k = 0;
        
        while (current2 < nums.length) {
            nums[current1] = nums[current2];
            k++;
            
            if (current2 < nums.length - 1 && nums[current1] == nums[current2 + 1]) {
                current1++;
                nums[current1] = nums[current2];
                k++;
            }
            
            while (current2 < nums.length && nums[current1] == nums[current2])
                current2++;
            
            current1++;
        }
        
        return k;
    }
}