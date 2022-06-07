/*
 * Merge Sorted Array - Given two arrays and two integers, m and n, representing the number of elements
 * in each array respectively, merge the two arrays while keeping them sorted. The merged
 * array should be placed into the first given array, not a new array. The first array
 * has a size of m + n to account for the second array's elements.
 * 
 * We could brute force this, placing all elements into a new array, sorting it, then setting
 * nums1 to the resulting array.
 * A better approach would be to merge from back to front. Since we have extra space at the end of
 * nums1, placing elements into nums1 starting from the back would prevent data in nums1 from
 * being overwritten. So we can start iterating through both lists using two pointers, plus a third
 * pointer to keep track of our current result index in nums1. We check which element is greater,
 * and add that element to the back of nums1. When we reach the beginning of either nums1 or
 * nums2, we break out of the while loop, then iterate through the remaining elements of the other
 * array, adding them to our new resulting nums1 array.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m + n - 1;
        int current1 = m - 1;
        int current2 = n - 1;
        
        while (current1 >= 0 && current2 >= 0) {
            if (nums1[current1] > nums2[current2]) {
                nums1[i] = nums1[current1];
                current1--;
                i--;
            }
            else {
                nums1[i] = nums2[current2];
                current2--;
                i--;
            }
        }
        
        if (current1 >= 0) {
            while (current1 >= 0) {
                nums1[i] = nums1[current1];
                current1--;
                i--;
            }
        }
        else {
            while (current2 >= 0) {
                nums1[i] = nums2[current2];
                current2--;
                i--;
            }
        }
    }
}