class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> strMap = new HashMap<>();
        
        strMap.put('2', "abc");
        strMap.put('3', "def");
        strMap.put('4', "ghi");
        strMap.put('5', "jkl");
        strMap.put('6', "mno");
        strMap.put('7', "pqrs");
        strMap.put('8', "tuv");
        strMap.put('9', "wxyz");
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < digits.length(); i++)
        {
            char current = digits.charAt(i);
            String currentString = strMap.get(current);
            
            if (i == 0)
            {
                for (int j = 0; j < currentString.length(); j++)
                {
                    list.add(Character.toString(currentString.charAt(j)));
                }
                
                continue;
            }
            
            int length = list.size();
            
            for (int k = 0; k < length; k++)
            {
                String old = list.get(k);
                String newString = old + Character.toString(currentString.charAt(0));
                
                list.set(k, newString);
                
                for (int w = 1; w < currentString.length(); w++)
                {
                    newString = old + Character.toString(currentString.charAt(w));
                    list.add(newString);
                }
            }
        }
        
        return list;
    }
}