/*
 * Search Insert Position - Given a sorted array of integers and a target, search for
 * the target number and return its index. If it is not found, return the index where it
 * would be placed if it was inserted into the array.
 * 
 * We use binary search to search for target. If target is found, return that index. If it
 * is ultimately not found, return either the low point or high point, since they are the
 * same value when the search ends, and that value is the insertion point.
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        
        while (hi >= lo) {
            mid = (lo + hi) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}