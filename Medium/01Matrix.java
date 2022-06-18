/*
 * 01 Matrix - Given an matrix of 0s and 1s, return the distance to the nearest 0 for each cell.
 * 
 * Yes
 */

class Solution {
    int[] directions = new int[]{0, 1, 0, -1, 0};
    
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0)
                    q.offer(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newR = r + directions[i];
                int newC = c + directions[i + 1];
                
                if (newR < 0 || newR == rows || newC < 0 || newC == cols || mat[newR][newC] != -1)
                    continue;
                
                mat[newR][newC] = mat[r][c] + 1;
                q.offer(new int[]{newR, newC});
            }
        }
        return mat;
    }
}