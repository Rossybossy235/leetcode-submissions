/*
 * Flood Fill - Given a 2d array of integers representing pixel colors, a starting row and column,
 * and an integer newColor, perform a flood fill from the starting pixel. To do a flood fill,
 * change the color of any pixel connected four-directionally to the starting pixel, and any pixels
 * connected four-directionally to those pixels, and so on.
 * 
 * We use a depth first search. We recursively visit every pixel connected four-directionally to pixels
 * with the same starting color as the starting pixel, changing the color as we go. We return if the 
 * current pixel is out of bounds, or the pixel does not have the same starting color, or if the pixel 
 * is already the color we want to change to.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(sr, sc, image[sr][sc], newColor, image);
        
        return image;
    }
    
    public void fill(int x, int y, int oldColor, int color, int[][] img) {
        
        if (x < 0 || y < 0 || x >= img.length || y >= img[0].length) {
            return;
        }
        if (img[x][y] != oldColor || img[x][y] == color) {
            return;
        }
        
        img[x][y] = color;
        
        fill(x - 1, y, oldColor, color, img);
        fill(x + 1, y, oldColor, color, img);
        fill(x, y - 1, oldColor, color, img);
        fill(x, y + 1, oldColor, color, img);
    }
}