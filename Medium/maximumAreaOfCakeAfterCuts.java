/*
 * Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts - Given the width and height
 * of a rectangular cake, and 2 arrays of integers representing the locations of vertical and
 * horizontal cuts on the cake, find the maximum area of a piece of cake after the cuts are
 * made.
 * 
 * We want to find the largest vertical and horizontal intervals on the cake. First, we sort the 
 * arrays, then we iterate over the arrays, keeping track of the largest interval. We also check
 * if the largest interverals are on the edges of the cake. Then, we return the area covered
 * by the largest intervals, using a modulo operation in case the numbers are too large (it is
 * specified that we should return the area % 10^9 + 7).
 */

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHeight = horizontalCuts[0];
        long maxWidth = verticalCuts[0];
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            if (horizontalCuts[i] - horizontalCuts[i - 1] > maxHeight)
                maxHeight = horizontalCuts[i] - horizontalCuts[i - 1];
        }
        
        if (h - horizontalCuts[horizontalCuts.length - 1] > maxHeight)
            maxHeight = h - horizontalCuts[horizontalCuts.length - 1];
        
        for (int i = 1; i < verticalCuts.length; i++) {
            if (verticalCuts[i] - verticalCuts[i - 1] > maxWidth)
                maxWidth = verticalCuts[i] - verticalCuts[i - 1];
        }
        
        if (w - verticalCuts[verticalCuts.length - 1] > maxWidth)
            maxWidth = w - verticalCuts[verticalCuts.length - 1];
        
        return (int) ((maxHeight * maxWidth) % (1000000007));
    }
}