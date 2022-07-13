/*
 * Search In Rotated Sorted Array - Given a sorted array of integers that is then rotated, and a 
 * target value to search for, return the index of the target array. Return -1 if it is not in
 * the array. 
 * 
 * We use a modified binary search to account for the rotation. We pick a direction to move depending
 * on whether the target is in the first or second part of the array portion we are looking at.
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        while (start <= end) {
            mid = (start + end) / 2;
            
            if (nums[mid] == target)
                return mid;
            else if (nums[end] < nums[start] && nums[start] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (nums[mid] <= nums[end] && nums[end] < nums[start]) {
                if (target >= nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else if (nums[mid] >= nums[start] && nums[mid] <= nums[end]) {
                if (target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}