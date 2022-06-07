/*
 * Check if Every Row and Column Contains All Numbers - given an n x n matrix,
 * determine whether every row and column contains all numbers from 1-n.
 * 
 * This approach uses two hash maps, one for rows, and one for columns. We can iterate 
 * over rows and columns at the same time, attempting to add elements into their 
 * respective hash maps. If add() returns false, then that means the number already
 * exists in the hash map. If the numbers is already in the hash map, then we know that
 * the current row cannot hold all the numbers from 1-n, and we return false.
 */

class Solution {
    public boolean checkValid(int[][] matrix) {
        
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) {
                    return false;
                }
            }
            row.clear();
            col.clear();
        }
        
        return true;
    }
}