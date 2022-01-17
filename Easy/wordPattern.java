class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        int pos = -1;
        char c = ' ';
        int k = 0;
        
        HashMap<Character, String> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ' && k < pattern.length())
            {
                c = pattern.charAt(k);
                
                if (!map.containsKey(c))
                {
                    if (!map.containsValue(s.substring(pos + 1, i)))
                    {
                        map.put(c, s.substring(pos + 1, i));
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if (!map.get(c).equals(s.substring(pos + 1, i)))
                    {
                        return false;
                    }
                }
                pos = i;
                k++;
            }
            else if (i < s.length() && k == pattern.length())
            {
                return false;
            }
        }
        
        if (k < pattern.length() - 1)
        {
            return false;
        }
        
        c = pattern.charAt(k);
        
        if (map.containsKey(c))
        {
            if (!map.get(c).equals(s.substring(pos + 1)))
            {
                return false;
            }
        }
        else
        {
            if (map.containsValue(s.substring(pos + 1)))
            {
                return false;
            }
        }
        
        return true;
    }
}