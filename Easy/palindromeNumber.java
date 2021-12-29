package Easy;
class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        
        char[] strArr = str.toCharArray();
        
        String reversed = "";
        
        for (int i = str.length() - 1; i >= 0; i--)
        {
            reversed = reversed + strArr[i];
        }
        
        if (reversed.equals(str))
            return true;
        else
            return false;
    }
}