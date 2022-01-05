class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        solve(0, result, new ArrayList<String>(), s);
        return result;
    }
    
    void solve(int startIndex, List<List<String>> result, List<String> currentList, String s)
    {
        if (startIndex >= s.length())
            result.add(new ArrayList<String>(currentList));
        
        for (int i = startIndex; i < s.length(); i++)
        {
            if (isPalidrome(s, startIndex, i))
            {
                currentList.add(s.substring(startIndex, i + 1));
                
                solve(i + 1, result, currentList, s);
                
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    
    boolean isPalidrome(String s, int low, int high)
    {
        while (low < high)
        {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        
        return true;
    }
}