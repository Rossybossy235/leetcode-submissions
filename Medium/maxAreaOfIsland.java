/*
 * Max Area of Island - Given a 2d array consisting of 0s and 1s, 1s representing islands and 0s
 * representing water, return the size of the largest island. An island is a group of 1s connected
 * four-directionally to each other.
 * 
 * We use depth first search. We have to loop through the entire 2d array to make sure we visit
 * all islands. When we encounter an island, we start a recursive depth-first search to go to all
 * 1s connected to the island. A counter variable is incremented on each "1" of the island, and that
 * "1" is set to 0 to make it so we don't visit that island multiple times. If counter > max, then
 * we update max.
 */

class Solution {
    
    int max = 0;
    int count = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    area(i, j, grid);
                }
            }
        }
        
        return max;
    }
    
    public void area(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if (grid[x][y] != 1)
            return;
        
        count++;
        grid[x][y] = 0;
        
        if (count > max)
            max = count;
        
        area(x - 1, y, grid);
        area(x + 1, y, grid);
        area(x, y - 1, grid);
        area(x, y + 1, grid);
    }
}