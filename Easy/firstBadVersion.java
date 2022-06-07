/*
 * First Bad Version - given an integer n, which represents the highest number in a sequence
 * where one number and all numbers after it are considered bad versions, find that first
 * bad version. Use the provided function isBadVersion(int num) to see whether a number is
 * a bad version.
 * 
 * We use binary search. Start in the middle, if the midpoint is a bad version, update index, 
 * and look left, if the midpoint is not a bad version, do not update index, and look right.
 * When our low and high points intersect, we will have determined the first bad version in
 * the sequence.
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            
            long lo = 1;
            long hi = n;
            long index = -1;
            
            while (hi >= lo) {
                long mid = (hi + lo) / 2;
                
                if (isBadVersion((int) mid)) {
                    index = mid;
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            
            return (int) index;
        }
    }