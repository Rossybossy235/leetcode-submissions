/*
 * Queue Reconstruction by Height - Given a 2d array representing a group of people, with information
 * on their heights and how many people can go before them with height >= theirs, order the people
 * into a queue such that each person has the required number of people before them with height >=
 * theirs.
 * 
 * First, we sort the given array by heights. Then, we iterate through the array, starting with the
 * smallest height. We use a counter to keep track of whether we are at the desired index to place
 * an element. We increment the counter if the current place does not have an entry, or if the
 * entry has the same height as our current element. When our counter equals the current element's
 * number of people with height >= it, we place the element. If the desired location has an element,
 * we move right until we find an empty place.
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        
        for (int i = 0; i < res.length; i++) {
            res[i][0] = -1;
            res[i][1] = -1;
        }
        
        Arrays.sort(people, Comparator.comparingInt(o -> o[0]));
        
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            int j = 0;
            int k = 0;
            
            while (j != index) {
                if (res[k][0] == -1 || res[k][0] == people[i][0])
                    j++;
                k++;
            }
            while (res[k][0] != -1)
                k++;
            res[k] = people[i];
        }
        
        return res;
    }
}