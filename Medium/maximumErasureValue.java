/*
 * Maximum Erasure Value - Given an array of integers, you want to erase a subarray containing
 * unique integers. Find the maximum sum of elements within an erased subarray.
 * 
 * We use a sliding window. We start by placing the sum of previous elements into a new array. Then
 * we begin our sliding window. Each new value is placed into a hash map, sum is increased by that
 * value, and we increase the size of our window by one. When we encounter a value we have already
 * seen, we get the index of the original instance of that value. If that index is within our
 * window, we change the current max sum if needed, then subtract the sum of all elements before
 * the original instance. Then, we start a new window, and continue going through the list.
 */

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] sums = nums.clone();
        
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1];
        }
        
        int start = 0;
        int end = 0;
        int max = -1;
        
        while (end < nums.length) {
            
            if (map.containsKey(nums[end])) {
                int index = map.get(nums[end]);

                if (index >= start) {
                    max = Math.max(max, sum);

                    if (start == 0)
                        sum -= sums[index - 1];
                    else
                        sum -= sums[index - 1] - sums[start - 1];

                    start = index;
                }
            }
            
            sum += nums[end];
            map.put(nums[end], end + 1);
            end++;
        }
        
        max = Math.max(max, sum);
        return max;
    }
}