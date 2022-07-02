/*
 * Permutations - Given an array of integers, return all of the possible permutations of the array.
 * 
 * We use backtracking. We iterate through the possible numbers in the list, checking if our current
 * permutation already contains that number. If it does, we skip it. Otherwise, once the size of
 * our current permutation equals the size of the given array, we add it to our results list.
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        perm(permutes, curr, nums);
        return permutes;
    }
    
    public void perm(List<List<Integer>> permutes, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            permutes.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i]))
                continue;
            curr.add(nums[i]);
            perm(permutes, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}