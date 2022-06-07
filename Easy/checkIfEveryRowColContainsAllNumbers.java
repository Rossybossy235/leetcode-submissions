/*
 * Check if Every Row and Column Contains All Numbers - given an n x n matrix,
 * determine whether every row and column contains all numbers from 1-n.
 * 
 * This is a brute force approach, looping over every row, then looping over every column.
 * We add unique element values into an array list for each row and column. Each time, if the length
 * of the array list != n, then that particular row/column does not contain all numbers 1-n.
 */

class Solution {
    public boolean checkValid(int[][] matrix) {
        List<Integer> nums = new ArrayList<Integer>();
        
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!nums.contains(matrix[i][j]))
                    nums.add(matrix[i][j]);
            }
            
            if (nums.size() != n) {
                return false;
            }
            
            nums.clear();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!nums.contains(matrix[j][i]))
                    nums.add(matrix[j][i]);
            }
            
            if (nums.size() != n) {
                return false;
            }
            
            nums.clear();
        }
        
        return true;
    }
}