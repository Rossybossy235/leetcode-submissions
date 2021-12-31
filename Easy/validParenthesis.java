package Easy;

class Solution {
    public boolean isValid(String s) {
        
        char[] strArr = s.toCharArray();
        int length = strArr.length;
        
        Stack<Character> strStack = new Stack<Character>();
        
        for (int i = 0; i < length; i++)
        {
            if (strArr[i] == '(')
            {
                strStack.push('(');
            }
            else if (strArr[i] == '{')
            {
                strStack.push('{');
            }
            else if (strArr[i] == '[')
            {
                strStack.push('[');
            }
            else if (strArr[i] == ')')
            {
                if (strStack.size() == 0)
                    return false;
                else if (strStack.pop() != '(')
                    return false;
            }
            else if (strArr[i] == '}')
            {
                if (strStack.size() == 0)
                    return false;
                else if (strStack.pop() != '{')
                    return false;
            }
            else if (strArr[i] == ']')
            {
                if (strStack.size() == 0)
                    return false;
                else if (strStack.pop() != '[')
                    return false;
            }
        }
        
        if (strStack.size() > 0)
            return false;
        else
            return true;
    }
}
