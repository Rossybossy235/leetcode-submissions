class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int soldiers[] = new int[rows];
        for (int i = 0; i < rows; i++)
        {
            int count = 0;
            for (int j = 0; j < cols; j++)
            {
                if (mat[i][j] == 1)
                {
                    count++;
                }
            }
            soldiers[i] = count;
        }
        
        int result[] = new int[k];
        
        for (int i = 0; i < k; i++)
        {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            
            for (int j = 0; j < soldiers.length; j++)
            {
                if (soldiers[j] < min)
                {
                    min = soldiers[j];
                    minIndex = j;
                }
            }
            result[i] = minIndex;
            soldiers[minIndex] = Integer.MAX_VALUE;
        }
        
        return result;
    }
}