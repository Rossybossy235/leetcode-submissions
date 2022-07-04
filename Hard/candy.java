/*
 * Candy - Given an arrays of integers representing a group of childrens' ratings, where children with
 * higher ratings are given more candy than their neighbors in the list, return the minimum amount of
 * candy given to the children such all ratings are satisfied.
 * 
 * We can start by having a results array with one in each element since each child will be given at 
 * least one candy. Then, we iterate through the list, looking left of each element, and increasing
 * the number of candies in that element if the current element's rating is greater than the previous.
 * Then, we iterate again, this time starting from the back of the least, and we look to the right
 * of the current element. At the end, we loop through our results array, and count the number of 
 * candies.
 */

class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int count = 0;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        
        for (int i = 0; i < len; i++) {
            count += candies[i];
        }
        
        return count;
    }
}