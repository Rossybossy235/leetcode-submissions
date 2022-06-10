/*
 * Find First And Last Position of Element in Sorted Array - Given an array of integers and a
 * target, first the first occurence of the target and the last occurence of the target.
 * 
 * We use two binary searches. During the first, if we find an instance of the target, we keep
 * looking to the left to see if there are any earlier occurences. During the second, if we find 
 * an instance of the target, we keep looking to the right to see if there are any later occurences
 * of the target.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int index1 = -1;
        int index2 = -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) {
                index1 = mid;
                hi = mid - 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) {
                index2 = mid;
                lo = mid + 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        int[] res = {index1, index2};
        return res;
    }
}