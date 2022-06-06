/*
 * Number of 1 Bits - Given an unsigned integer, return the number of "1" bits
 * the number has.
 * 
 * Using bitwise "and" and "unsigned right shift (>>>, signed is >>, adds the sign bit to the
 * right side)", we can iterate over the given integer's bits.
 * Using bitwise and, we can check if the rightmost bit is a one, and increment our count. 
 * After the check, we use a bitwise unsigned right shift to move to the next bit.
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int numOne = 0;
        
        while (n != 0) {
            if ((n & 1) == 1) {
                numOne++;
            }
            n >>>= 1;
        }
        
        return numOne;
    }
}