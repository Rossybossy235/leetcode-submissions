class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        
        generate("(", 1, 0, n, list);
        
        return list;
    }
    
    public void generate(String str, int open, int close, int max, List<String> list)
    {
        if (open == max && close == max)
        {
            list.add(str);
            return;
        }
        
        if (open < max)
        {
            generate(str + "(", open + 1, close, max, list);
        }
        if (close < open)
        {
            generate(str + ")", open, close + 1, max, list);
        }
    }
}