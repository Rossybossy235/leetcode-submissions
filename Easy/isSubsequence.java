class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        
        for(int i = 0; i < t.length() && count < s.length(); i++)
        {
            if (s.charAt(count) == t.charAt(i))
                count++;
        }
        
        if (count == s.length())
            return true;
        else
            return false;
    }
}