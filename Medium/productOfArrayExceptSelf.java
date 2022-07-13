/*
 * Product Of Array Except Self - Given an array of integers, return a list such that each element
 * is the product of every element in the array except itself.
 * 
 * We use a running product, storing it in the original array, checking if there is more than one zero
 * in the list. Then for each element, the product of every element except itself is the last element
 * in our array of products / the current element (for the elements after the current element), 
 * multiplied by the element before the current element (since we have a running product).
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroIndex = -1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                if (zeroIndex == -1)
                    zeroIndex = i;
                else
                    return new int[nums.length];
            }
            nums[i] *= nums[i - 1];
        }
        
        int[] res = new int[nums.length];
        if (zeroIndex != -1) {
            res[zeroIndex] = nums[nums.length - 1];
            return res;
        }
        
        res[0] = nums[nums.length - 1] / nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[nums.length - 1] / nums[i] * nums[i - 1];
        }
        
        return res;
    }
}