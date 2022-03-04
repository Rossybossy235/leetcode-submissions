class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0)
        {
            return 0;
        }
        
        double[] cups = new double[101];
        cups[0] = poured;
        
        for (int i = 0; i < query_row; i++)
        {
            for (int j = i; j >= 0; j--)
            {
                if (cups[j] > 1)
                {
                    double split = (cups[j] - 1) / 2;
                    cups[j + 1] += split;
                    cups[j] = split;
                }
                else
                {
                    cups[j] = 0;
                }
            }
        }
        
        return Math.min(1, cups[query_glass]);
    }
}