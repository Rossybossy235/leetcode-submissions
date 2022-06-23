/*
 * Defanging an IP Address - Given a string containing a valid ip address, return a defanged version
 * of that ip address. A defanged ip address replaced every '.' with "[.]".
 * 
 * We can simply use a string builder. We iterate over the list, checking if each character is a '.'.
 * If it is, we place "[.]" into the string builder. Otherwise, we place the character into the 
 * string builder.
 */

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder newAddr = new StringBuilder();
        
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.')
                newAddr.append("[.]");
            else
                newAddr.append(address.charAt(i));
        }
        
        return newAddr.toString();
    }
}