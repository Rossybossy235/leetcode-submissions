/*
 * Given a string and an integer k, reverse the first k characters in each block of the string of size
 * 2 * k. If k is greater than the length of the string, reverse the entire string.
 * 
 * We iterate through the string in segments of 2 * k. For every segment, we reverse the first
 * k characters. At each iteration, we check if there are at least k integers. If there are less than
 * k integers left, we reverse all the remaining characters.
 */

class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        
        for (int i = 0; i < str.length; i += 2 * k) {
            int start = i, min = Math.min(i + k - 1, str.length - 1);

            while (start < min) {
                char temp = str[start];
                str[start++] = str[min];
                str[min--] = temp;
            }
        }
        
        return String.valueOf(str);
    }
}