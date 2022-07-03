/*
 * Wiggle Subsequence - this problem is dumb just look at leetcode description
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int length = 1;
        int i = 1;
        boolean increase = false;
        boolean decrease = false;
        
        while (i < nums.length) {
            if (nums[i] == nums[i] - 1) {
                continue;
            }
            else if (nums[i] < nums[i - 1]) {
                if (increase)
                    length++;
                increase = false;
                decrease = true;
            }
            else if (nums[i] > nums[i - 1]) {
                if (decrease)
                    length++;
                increase = true;
                decrease = false;
            }
            
            i++;
        }
        
        if (increase || decrease)
            length++;
        
        return length;
    }
}