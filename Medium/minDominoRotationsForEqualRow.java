class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int length = tops.length;
        int[][] dominos = new int [6][3];
        
        for (int i = 0; i < length; i++)
        {
            if (tops[i] == bottoms[i])
            {
                dominos[tops[i] - 1][0]++;
                dominos[tops[i] - 1][1]++;
                dominos[tops[i] - 1][2]++;
            }
            else
            {
                dominos[tops[i] - 1][0]++;
                dominos[tops[i] - 1][1]++;
                dominos[bottoms[i] - 1][0]++;
                dominos[bottoms[i] - 1][2]++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < 6; i++)
        {
            if (dominos[i][0] == length)
            {
                min = Math.min(min, Math.min(length-dominos[i][1], length - dominos[i][2]));
            }
        }
        
        if (min < length)
        {
            return min;
        }
        
        return -1;
    }
}