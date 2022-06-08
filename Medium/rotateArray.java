/*
 * Rotate Array - Given an array of integers and an integer k, rotate the array k
 * times to the right.
 * 
 * We will solve this problem by doing array reversals with two pointers.
 * First, we reverse the full array, as that will place the desired elements at
 * the beginning of the list. Then we reverse the first k elements. This will sort
 * the rotated elements at the beginning of the list. Then we reverse the rest of
 * the elements, which will sort the rest of the elements.
 * Notice that at the beginning, we used k %= nums.length. This is an optimization,
 * and ensures that the elements will be rotated correctly if k > nums.length.
 * For example, if nums.length = 2, and k = 3, doing k %= nums.length will change
 * k to 1. This ensures that we can correctly reverse each part of the list, while
 * moving elements to the correct places.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        
        if (nums.length == 1)
            return;
        
        k %= nums.length;
        
        int current1 = 0;
        int current2 = nums.length - 1;
        
        while (current1 <= current2) {
            int temp = nums[current1];
            nums[current1] = nums[current2];
            nums[current2] = temp;
            current1++;
            current2--;
        }
        
        current1 = 0;
        current2 = k - 1;
        
        while (current1 <= current2) {
            int temp = nums[current1];
            nums[current1] = nums[current2];
            nums[current2] = temp;
            current1++;
            current2--;
        }
        
        current1 = k;
        current2 = nums.length - 1;
        
        while (current1 <= current2) {
            int temp = nums[current1];
            nums[current1] = nums[current2];
            nums[current2] = temp;
            current1++;
            current2--;
        }
    }
}