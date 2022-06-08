/*
 * Final Value Of Variable After Performing Operations - Given an array of strings
 * denoting operations "++x", "x++", "--x", and "x--", return the final value of a 
 * variable after performing the operations in order. Variable value should start
 * at 0.
 * 
 * We can simply loop through the given array. If the array element contains "++", we
 * increment our variable by 1, if the array element contains "--", we decrement
 * our variable by 1.
 */

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("++"))
                x++;
            else if (operations[i].contains("--"))
                x--;
        }
        
        return x;
    }
}