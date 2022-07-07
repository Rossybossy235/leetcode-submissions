/*
 * Interleaving String - Given 3 strings, determine if the third string can be made with all of the
 * characters of the other two strings. The relative order of the characters from the first 2 
 * strings must be kept the same.
 * 
 * We use both backtracking and memoization for this problem. We recursively backtrack through the
 * string, checking if we have the correct characters to use. We place new calculations into a 3d
 * array, and skip calculations we have already done to lower the runtime.
 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        Integer[][][] memo = new Integer[101][101][200];
        
        for (int i = 0; i < s1.length() + 1; i++)
            for (int j = 0; j < s2.length() + 1; j++)
                for (int k = 0; k < s3.length(); k++)
                    memo[i][j][k] = -1;
        
        return backtrack(0, 0, 0, s1, s2, s3, memo);
    }
    
    public boolean backtrack(int index1, int index2, int index3, String s1, String s2, String s3, Integer[][][] memo) {
        if (index3 >= s3.length() && index1 >= s1.length() && index2 >= s2.length())
            return true;
        if (index3 >= s3.length() || ((index1 >= s1.length() || s1.charAt(index1) != s3.charAt(index3)) && (index2 >= s2.length() || s2.charAt(index2) != s3.charAt(index3))))
            return false;
        
        if (memo[index1][index2][index3] == -1) {
            memo[index1][index2][index3] = 1;
            if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3))
                if (backtrack(index1 + 1, index2, index3 + 1, s1, s2, s3, memo))
                    memo[index1][index2][index3] = 0;

            if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3))
                if (backtrack(index1, index2 + 1, index3 + 1, s1, s2, s3, memo))
                    memo[index1][index2][index3] = 0;
        }
        
        if (memo[index1][index2][index3] == 0)
            return true;
        else
            return false;
    }
}