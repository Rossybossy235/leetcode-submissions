/*
 * Partitioning Into Minimum Number of Deci-Binary Numbers - Given a string n that represents a 
 * positive integer, return the minimum number of deci-binary numbers (i.e. numbers that consist
 * only of 0s and 1s) such that they sum up to n.
 * 
 * The trick for this problem is seeing that since the numbers can only consist of 1s and 0s,
 * a digit k needs k numbers to equal that digit (i.e. 3 needs 3 numbers, 5 needs 5 numbers, etc).
 * So, all we need to do is look at the number and find the largest digit in the number, and that is
 * the minimum amount of numbers you need to equal the given number.
 */

class Solution {
    public int minPartitions(String n) {
        int res = 0;
        
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        
        return res;
    }
}