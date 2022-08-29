/*
 * Reordered Power of 2 - Given an integer, determine whether the digits of the integer can be
 * rearranged to form an integer such that it is a power of 2.
 * 
 * First, we take the counts of each digit in the given integer. Then, we iterate over each power of 
 * 2, getting the counts of each power's digits. We loop 31 times since n can only be 1*10^9. If 
 * the counts match, then n can be rearranged. If we finish looping and did not find a match, n
 * cannot be rearranged.
 */

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] counts = count(n);
        
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(counts, count(1 << i)))
                return true;
        }
        
        return false;
    }
    
    public int[] count(int n) {
        int[] res = new int[10];
        
        while (n > 0) {
            res[n % 10]++;
            n = n / 10;
        }
        
        return res;
    }
}