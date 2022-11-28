/*
 * Find Players With 0 or 1 Losses - Given a 2d array, where matches[i] = [winner, loser], return a
 * list where answer[0] is a list of players that have not lost a match, and answer[1] is a list of
 * players that have lost exactly 1 match. The values in the lists should be in increasing order.
 * 
 * We use an array to hold each player's number of losses. Then, we iterate through the array, adding
 * players to lists if they have 0 losses or 1 loss.
 */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        int[] count = new int[100001];
        Arrays.fill(count, -1);

        for (int[] m : matches) {
            int w = m[0];
            int l = m[1];

            if (count[w] == -1)
                count[w] = 0;
            if (count[l] == -1) 
                count[l] = 1;
            else
                count[l]++;
        }

        for (int i = 1; i < 100001; i++) {
            if (count[i] == 0)
                res.get(0).add(i);
            else if (count[i] == 1)
                res.get(1).add(i);
        }

        return res;
    }
}