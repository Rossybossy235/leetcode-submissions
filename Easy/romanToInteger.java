package Easy;

class Solution {
    public int romanToInt(String s) {
        
        
        char[] charArr = s.toCharArray();
        
        int previous = 0;
        int totalSum = 0;
        
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        
        for(char letter : charArr)
        {
            int currentNum = charMap.get(letter);
            
            if (previous < currentNum)
            {
                int num = (-1) * (previous - currentNum);
                totalSum = totalSum + num - previous;
            }
            else
            {
                totalSum = totalSum + currentNum;
            }
            previous = currentNum;
        }
        
        return totalSum;
    }
}
