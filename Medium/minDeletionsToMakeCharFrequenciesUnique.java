/*
 * Minimum Deletions To Make Character Frequencies Unique - Given a string, determine the minimum
 * number of characters that need to be deleted such that no characters appear the same number of
 * times.
 * 
 * Since we can't sort an array in descending order without a loop, we'll use an arraylist instead. 
 * We place the frequencies of each character into the arraylist, then sort that arraylist in
 * descending order. Then, we loop through the arraylist. If the current frequency is >= the
 * previous, we get the difference between them plus one, as that is the number of deletions
 * needed for the current frequency. We add that to our counter, and change the current frequency.
 * At the end, our counter will have the total number of deletions needed.
 */

class Solution {
    public int minDeletions(String s) {
        
        List<Integer> freq = new ArrayList<>(26);
        int count = 0;
        
        for (int i = 0; i < 26; i++)
            freq.add(0);
        
        for (int i = 0; i < s.length(); i++) {
            freq.set(s.charAt(i) - 'a', freq.get(s.charAt(i) - 'a') + 1);
        }
        
        Collections.sort(freq, Collections.reverseOrder());
        
        for (int i = 1; i < 26; i++) {
            if (freq.get(i) == 0) break;
            
            if (freq.get(i) >= freq.get(i - 1)) {
                int diff = Math.min(freq.get(i), (freq.get(i) - freq.get(i - 1)) + 1);
                count += diff;
                freq.set(i, freq.get(i) - diff);
            }
        }
        
        return count;
    }
}