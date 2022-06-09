/*
 * Rotate Matrix - Given a 2d matrix of integers, rotate the matrix 90 degrees clockwise.
 * 
 * In order to rotate a matrix 90 degrees clockwise, we want to take the transpose of the
 * matrix and flip it horizontally. So, we iterate diagonally through the matrix, using
 * two pointers to go left and up from our current position, swapping those elements.
 * Then, to do a horizontal flip, we iterate through each row, also using two pointers
 * to swap the elements in those rows. 
 */

class Solution {
    public void rotate(int[][] matrix) {
        int c1 = 0;
        int c2 = 0;
        
        // transpose
        for (int i = 0; i < matrix.length; i++) {
            c1 = i;
            c2 = i;
            
            while (c1 >= 0 && c2 >= 0) {
                int temp = matrix[c1][i];
                matrix[c1][i] = matrix[i][c2];
                matrix[i][c2] = temp;
                
                c1--;
                c2--;
            }
        }
        
        // horizontal flip
        for (int i = 0; i < matrix.length; i++) {
            c1 = 0;
            c2 = matrix.length - 1;
            
            while (c1 < c2) {
                int temp = matrix[i][c1];
                matrix[i][c1] = matrix[i][c2];
                matrix[i][c2] = temp;
                
                c1++;
                c2--;
            }
        }
    }
}