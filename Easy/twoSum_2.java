/**
 * Two Sum - given an array of integers, find two numbers that add up to a target.
 * 
 * We want to sort the given array, but we need to save the previous indices, so
 * we create a new array to hold them.
 * We use an Arrays.sort() lamba function to sort the indices array based on the integers
 * in nums. Then we use two counters at the beginning and the end of nums. When
 * nums[counter1] + nums[counter2] > target, we move counter2 back, and when
 * nums[counter1] + nums[counter2] < target, we move counter1 forward until we find
 * two numbers that add up to target or until they have gone through the whole list.
 * Then we return the indices of the two integers using the index array.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return nums[a] - nums[b];
            }
        });
        
        Arrays.sort(nums);
        int count1 = 0;
        int count2 = nums.length - 1;
        
        while (count1 < count2) {
            if (nums[count1] + nums[count2] == target) {
                int[] res = {index[count1], index[count2]};
                return res;
            }
            else if (nums[count1] + nums[count2] > target) {
                count2--;
            }
            else {
                count1++;
            }
        }
        
        return new int[0];
    }
}