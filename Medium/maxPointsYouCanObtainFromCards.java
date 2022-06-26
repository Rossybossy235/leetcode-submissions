/*
 * Maximum Points You Can Obtain From Cards - Given an array of integers representing cards and an
 * integer k, determine the maximum number of points you can get by taking k cards from either end
 * of the list.
 * 
 * We use a sliding window of length cardPoints.length - k. We place this window at the beginning
 * of the list, and move it through the list, looking for the minimum number of card points in the
 * window. Once we have the minimum, we subtract it from the total sum of the cards, and we have our
 * max.
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int lo = 0;
        int hi = cardPoints.length - k - 1;
        
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        
        int currentSum = 0;
        
        for (int i = lo; i <= hi; i++) {
            currentSum += cardPoints[i];
        }
        
        if (currentSum < min)
            min = currentSum;
        
        lo++;
        hi++;
        
        while (hi < cardPoints.length) {
            
            currentSum += cardPoints[hi];
            currentSum -= cardPoints[lo - 1];
            
            if (currentSum < min)
                min = currentSum;
            
            lo++;
            hi++;
        }
        
        return sum - min;
    }
}