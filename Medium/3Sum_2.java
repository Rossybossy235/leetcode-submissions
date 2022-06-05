/*
 * 3 Sum - Given a list of integers, find all unique triples that add up to 0. Triples
 * must be unique and indexes of found integers must be unique.
 * 
 * Similar to 2Sum, we can use two counter variables. We loop through nums to check each number,
 * setting count1 to the index immediately after, and count2 to the end. We don't set count1
 * to the beginning to avoid some duplicates.
 * Since the numbers must add up to zero, the second and third numbers must add up to the first
 * number * -1.
 * When we find a triple, we add it to the result list, the loop through the list until we find
 * a new number, incrementing count1 and decrementing count2 as we go. Then we increment and
 * decrement once more to place count1 and count2 on the new numbers, and we continue checking. 
 * Increment count1 if the second and third numbers are less than the target, and decrement count2
 * if the numbers are greater than the target.
 * Then, we loop i to place it on a new unique number to avoid duplicates.
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            int count1 = i + 1;
            int count2 = nums.length - 1;
            
            while (count1 < count2) {
                if (nums[count1] + nums[count2] == (nums[i] * -1)) {
                    res.add(Arrays.asList(nums[i], nums[count1], nums[count2]));
                    
                    while (count1 < count2 && nums[count1] == nums[count1 + 1]) {
                        count1++;
                    }
                    while (count1 < count2 && nums[count2] == nums[count2 - 1]) {
                        count2--;
                    }
                    count1++;
                    count2--;
                }
                else if (nums[count1] + nums[count2] < (nums[i] * -1)) {
                    count1++;
                }
                else {
                    count2--;
                }
            }
            
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return res;
    }
}