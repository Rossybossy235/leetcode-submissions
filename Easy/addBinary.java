class Solution {
    public String addBinary(String a, String b) {
        StringBuilder newStr = new StringBuilder();
        
        int carry = 0;
        int aLen = a.length();
        int bLen = b.length();
        
        while (aLen > 0 && bLen > 0)
        {
            int sum = carry + (a.charAt(aLen - 1) - '0') + (b.charAt(bLen - 1) - '0');
            
            carry = sum / 2;
            if (sum % 2 != 0)
            {
                newStr.append('1');
            }
            else
            {
                newStr.append('0');
            }
            
            aLen--;
            bLen--;
        }
        
        while (aLen > 0)
        {
            int sum = carry + (a.charAt(aLen - 1) - '0');
			carry = sum / 2;

			if(sum % 2 != 0)
            {
				newStr.append('1');
            }
			else
            {
				newStr.append('0');
            }
			aLen--;
        }
        
        while (bLen > 0)
        {
            int sum = carry + (b.charAt(bLen - 1) - '0');
			carry = sum / 2;

			if(sum % 2 != 0)
            {
				newStr.append('1');
            }
			else
            {
				newStr.append('0');
            }
			bLen--;
        }
        
        if (carry != 0)
        {
            newStr.append('1');
        }
        
        newStr.reverse();
        
        return newStr.toString();
    }
}