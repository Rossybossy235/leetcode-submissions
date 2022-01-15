class Solution {
    public int maxArea(int[] height) {
        
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        
        while (start < end)
        {
            max = Math.max(max, (end - start) * Math.min(height[end], height[start]));
            
            if (height[end] > height[start])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        
        return max;
    }
}