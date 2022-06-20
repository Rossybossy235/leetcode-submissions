/*
 * Reverse Bits - given an integer, return the reverse of that integer's bits.
 * 
 * We iterate through the 32 bits. We right shift n by 1, and if the last bit is a 1, we left shift
 * result by 1, then add a 1 to it. Then, to get rid of the bit we've used, we right shift n by
 * one.
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
    
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            
            if ((n & 1) == 1) 
                result++;
            
            n >>= 1;
        }
        
        return result;
    }
}