/*
 * Container with most water - Given a list of heights, find the largest area that can fit
 * between two of these heights.
 * 
 * We use the two pointer approach, setting one to the beginning and one to the end.
 * In each iteration, we check if the two heights give a greater max area than the previous
 * area. If it is larger, we change maxArea. During each iteration, we move the pointer with
 * a smaller height, in the hope that we find a larger one, which may give us a larger area.
 */

class Solution {
    public int maxArea(int[] height) {
        
        int h1 = 0;
        int h2 = height.length - 1;
        int maxArea = -1;
        
        while (h1 < h2) {
            int newArea = Math.min(height[h1], height[h2]) * (h2 - h1);
            
            if (newArea > maxArea) {
                maxArea = newArea;
            }
            
            if (height[h1] < height[h2]) {
                h1++;
            }
            else {
                h2--;
            }
        }
        
        return maxArea;
    }
}