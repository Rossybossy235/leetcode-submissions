class Solution {
    public int climbStairs(int n) {
        
        int[] steps = new int[n + 1];
        
        return countPaths(n, steps);
    }
    
    public int countPaths(int n, int[] stepArray)
    {
        if (n == 0)
        {
            return 1;
        }
        if (n == 1)
        {
            return 1;
        }
        
        if (stepArray[n] != 0)
        {
            return stepArray[n];
        }
        
        int left = countPaths(n - 1, stepArray);
        int right = countPaths(n - 2, stepArray);
        
        return stepArray[n] = left + right;
    }
}