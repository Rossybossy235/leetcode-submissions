/*
 * Pow(x,n) - Implement pow(x,n) which raises x to the power of n.
 * 
 * We recursively multiple x by itself, taking into account negative exponents and integer 
 * overflow.
 */

class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0)
            return 1;
        
        if (n < 0) {
            return (1 / x) * myPow(1 / x, -(n + 1));
        }
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}