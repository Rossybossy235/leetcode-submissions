/*
 * 3 Sum Closest - Given a list of integers and a target, find the sum of three elements who's 
 * sum is the closest to the target.
 * 
 * Similar to 3Sum, we can use two pointers. We iterate through the list, checking if the 
 * difference between the sum of the current elements and the target is closer to the target than
 * the previous one. If it is closer, then we update our result sum and the variable of our 
 * closest difference. Then, if the current sum is less than the target, we increment the left
 * pointer. If the current sum is greater than the target, we decrement the right pointer.
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int curr1 = i + 1;
            int curr2 = nums.length - 1;
            
            while (curr1 < curr2) {
                
                int currentSum = nums[i] + nums[curr1] + nums[curr2];
                
                if (Math.abs(currentSum - target) < closest) {
                    
                    sum = currentSum;

                    closest = Math.abs(currentSum - target);
                }
                
                if (currentSum < target)
                    curr1++;
                else if (currentSum > target)
                    curr2--;
                else
                    return currentSum;
            }
        }
        
        return sum;
    }
}