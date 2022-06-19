/*
 * Power of 2 - Determine if a number is a power of 2.
 * 
 * A number that is a power of 2 in binary will be a single 1 bit with the rest being 0. Using this,
 * we can an and operation between the number and number - 1. If the and operation results in 0, then
 * the number is a power of 2.
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        
        if ((n & (n - 1)) == 0)
            return true;
        else
            return false;
    }
}