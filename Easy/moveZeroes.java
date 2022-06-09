/*
 * Move Zeroes - Given an array of integers, move any zeroes in the list to the end,
 * while keeping the relative order of non-zero elements the same.
 * 
 * We use two pointers. Both pointers start at the beginning of the list. We iterate
 * both pointers to the right until the first pointer is a zero. Then, we move the 
 * second pointer to the right until it lands on a non-zero element. We swap the two
 * elements, increment the first pointer once to the right, replace the second pointer
 * one space to the right of the first, and continue iterating.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;
        
        int current1 = 0;
        int current2 = current1 + 1;
        
        while (current2 < nums.length) {
            if (nums[current1] == 0) {
                while (current2 < nums.length && nums[current2] == 0) {
                    current2++;
                }
                
                if (current2 >= nums.length)
                    break;
                
                int temp = nums[current1];
                nums[current1] = nums[current2];
                nums[current2] = temp;
                
                current1++;
                current2 = current1 + 1;
            }
            else {
                current1++;
                current2++;
            }
        }
    }
}