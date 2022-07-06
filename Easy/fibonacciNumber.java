/*
 * Fibonacci Number - Calculate the fibonacci number of a given integer, such that each number in the
 * sum is the sum of the two preceding numbers.
 * 
 * We use a recursive solution. We recursively find the fibonacci number of every number between 0 and 
 * the given integer, by calling the function with the two preceding numbers as parameters.
 */

class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;
        
        return fib(n - 1) + fib(n - 2);
    }
}