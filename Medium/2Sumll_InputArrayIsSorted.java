/*
 * 2 Sum II - Input Array Is Sorted - Given an array of numbers and a target, return
 * the indices of the two elements that add up to target, increased by 1. Tests are made
 * such that there is one solution.
 * 
 * We can use the two pointer approach, one at the beginning of the list and one at the end.
 * We iterate through the list, if we find two elements that add up to the target, we place
 * them into our result array, adding 1 onto them. If the two elements' sum is less than
 * the target, we move current1 to the right, otherwise we move current2 to the left.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int current1 = 0;
        int current2 = numbers.length - 1;
        int[] res = new int[2];
        
        while (current1 < current2) {
            if (numbers[current1] + numbers[current2] == target) {
                res[0] = current1 + 1;
                res[1] = current2 + 1;
                return res;
            }
            else if (numbers[current1] + numbers[current2] < target)
                current1++;
            else
                current2--;
        }
        
        return res;
    }
}