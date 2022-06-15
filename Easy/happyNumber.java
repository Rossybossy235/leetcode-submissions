/*
 * Happy Number - Given an integer, determine whether it is a "happy number". A happy number is a 
 * number such that if you change the number by repeatedly replacing it with the sum of the squares 
 * of its digits, it will eventually equal 0. A non-happy number will go into an endless cycle,
 * eventually returning to the original number.
 * 
 * We can use a hashmap for this problem. We continually perform the necessary operations until the
 * number is already in the hashmap (we have returned to the original number), or the number equals
 * one.
 */

class Solution {
    public boolean isHappy(int n) {
        
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        int newNum;
        int remainder;
        
        while (!map.containsKey(n)) {
            
            map.put(n, true);
            
            newNum = 0;
            
            while (n > 0) {
                remainder = n % 10;
                newNum += remainder * remainder;
                n = n / 10;
            }
            
            if (newNum == 1)
                return true;
            
            n = newNum;
        }
        
        return false;
    }
}