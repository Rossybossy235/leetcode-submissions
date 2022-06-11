/*
 * Majority Element - Given an array of integers, determine the number that appears in the majority
 * of the list, i.e. more than length / 2 elements have that number.
 * 
 * We can use a hashmap, iterating through the list and placing the count of each number into the
 * hashmap. Then, we iterate through the hashmap with a foreach loop and find the number with the
 * highest count.
 */

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxNum = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        
        for (Map.Entry num : map.entrySet()) {
            if ((int) num.getValue() > maxNum) {
                maxNum = (int) num.getValue();
                res = (int) num.getKey();
            }
        }
        
        return res;
    }
}