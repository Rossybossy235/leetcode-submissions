/*
 * Counting Bits - Given an integer n, return an array of size n + 1 containing the number of 1 bits
 * in each number from 0 - n.
 * 
 * We use a dynamic programming approach. The trick is that the number of one bits can be determined
 * by looking at previous numbers. The current number's amount of 1 bits can be determined by looking
 * at the number produced by: current number & previous number, then adding one.
 */

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        res[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        
        return res;
    }
}