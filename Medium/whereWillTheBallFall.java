/*
 * Where Will The Ball Fall - You are given a 2D array representing a box, where each place has a value,
 * -1 or 1, representing whether a ball on that point will move left or right. Return an array such
 * that each index contains the column a ball will drop out of if placed into the top of the box at
 * the column of the array index. Indexes where the ball does not make it to the bottom should contain
 * -1. The ball will not make it to the bottom if it hits the edge of the box or falls into a "V", i.e. 
 * if the ball tries to go left, but the place immediately to the left goes right, the ball cannot go 
 * down. See leetcode problem for an illustration.
 * 
 * My solution for this problem uses a depth first search. For each column index, we traverse through
 * the grid until the ball reaches the bottom or the ball gets stuck. If the ball gets stuck, -1 is
 * placed into the current result array index. If we reach the bottom, the current column number is
 * placed into the array.
 */

class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = traverse(grid, i);
        }
        
        return res;
    }
    
    public int traverse(int[][] grid, int col) {
        int current = col;
        int level = 0;
        
        while (level < grid.length) {
            if (current < 0 || current > grid[0].length - 1)
                return -1;
            
            if (grid[level][current] == 1) {
                if (current == grid[0].length - 1)
                    return -1;
                else if (grid[level][current + 1] == -1)
                    return -1;
                
                current++;
            }
            else if (grid[level][current] == -1) {
                if (current == 0)
                    return -1;
                else if (grid[level][current - 1] == 1)
                    return -1;
                
                current--;
            }
            
            level++;
        }
        
        return current;
    }
}