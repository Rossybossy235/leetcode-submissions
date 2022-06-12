/*
 * Maximum Number of Words Found in Sentences - Given a list of strings, find the maximum number
 * of words that appear in each sentence. Each word is separated by one space, with no leading
 * or ending whitespace.
 * 
 * We simply loop through the array and each sentence, incrementing a counter variable every
 * time we encounter whitespace. If the current count is greater than the current max, we update
 * max. The counter variable starts at 1 to include the last word in each sentence, since that does
 * not have whitespace after it.
 */

class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        
        for (int i = 0; i < sentences.length; i++) {
            int count = 1;
            
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    count++;
                }
            }
            
            if (count > max)
                max = count;
        }
        
        return max;
    }
}