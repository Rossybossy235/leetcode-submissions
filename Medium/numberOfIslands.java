/*
 * Number of Islands - Given a 2d array consisting of 0s and 1s, 1s representing islands and 0s
 * representing water, return the number of islands.
 * 
 * We use depth first search. We have to loop through the entire 2d array to make sure we visit
 * all islands. When we encounter an island, we increment our island count and start a recursive 
 * depth-first search to go to all 1s connected to the island. All 1s on that island are set to 0 
 * such that we don't visit the same island multiple times.
 */

class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    remove(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public void remove(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if (grid[x][y] != '1')
            return;
        
        grid[x][y] = '0';
        
        remove(x - 1, y, grid);
        remove(x + 1, y, grid);
        remove(x, y - 1, grid);
        remove(x, y + 1, grid);
    }
}