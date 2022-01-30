class Solution {
    public String convert(String s, int numRows) {
        
        char[] chars = s.toCharArray();
        
        int length = chars.length;
        
        if (numRows == 1)
        {
            return s;
        }
        else
        {
            int count = 0;
            
            StringBuilder[] output = new StringBuilder[numRows];
            
            for (int i = 0; i < numRows; i++)
            {
                output[i] = new StringBuilder("");
            }
            
            while (count != length)
            {
                for (int i = 0; i < numRows && count < length; i++)
                {
                    output[i].append(chars[count++]);
                }
                
                for (int i = numRows - 2; i > 0 && count < length; i--)
                {
                    output[i].append(chars[count++]);
                }
            }
            
            StringBuilder result = new StringBuilder("");
            
            for (int i = 0; i < numRows; i++)
            {
                result.append(output[i]);
            }
            
            return result.toString();
        }
    }
}