/*
 * Make The String Great - Given a string of upper and lowercase letters, a string is not
 * great if there is a lowercase letter follow by the same uppercase letter, or an
 * uppercase letter followed by the same lowercase letter. Make the given string great, and
 * return it. A string can be made great by removing all adjacent pairs of same lowercase
 * and uppercase letters.
 * 
 * We start by placing the given string into a string builder. Then, while the length of the
 * string builder is greater than one, we iterate through the string builder. If we find a
 * pair, remove them from the string builder, set a flag to true, and skip to the next while
 * loop iteration. If, during an iteration, no pairs are found (the flag is still false), we 
 * break from the while and return the resulting string.
 */

class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder(s);

        while (res.length() > 1) {
            boolean flag = false;

            for (int i = 0; i < res.length() - 1; i++) {
                char curr = res.charAt(i);
                char next = res.charAt(i + 1);

                if (Math.abs(curr - next) == 32) {
                    res.deleteCharAt(i);
                    res.deleteCharAt(i);
                    flag = true;
                    break;
                }
            }

            if (flag == false)
                break;
        }

        return res.toString();
    }
}