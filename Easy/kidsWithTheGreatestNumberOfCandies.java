/*
 * Kids With the Greatest Number of Candies - given an array of integers representing the amount of
 * candies each child in a group has, determine whether each child will have the greatest number
 * of candies if each are given the amount of extraCandies. More than one child can have the 
 * greatest number of candies.
 * 
 * First we loop through the array to find the child with the greatest number of candies. Then we loop
 * through the array again to check whether each child will have the greatest number of candies if
 * given extraCandies.
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<Boolean>();
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max)
                max = candies[i];
        }
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }
        
        return res;
    }
}