/*
 * Search a 2D Matrix II - Given a 2d matrix and a target integer, search for the target integer
 * in the matrix. Values in each row are sorted in ascending order from left to right, and values
 * in each column are sorted in ascending order from top to bottom.
 * 
 * We can start searching in the top right corner of the matrix. Since values are sorted in ascending
 * order, we can move through the matrix depending on whether the current value is greater than or 
 * less than the target. If the current value is less than the target, we can move down a row. If
 * the current value is greater than the target, we can move left by a column.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currRow = 0;
        int currCol = cols - 1;
        
        while (currRow < rows && currCol >= 0) {
            if (matrix[currRow][currCol] == target)
                return true;
            
            if (matrix[currRow][currCol] < target)
                currRow++;
            else
                currCol--;
        }
        
        return false;
    }
}