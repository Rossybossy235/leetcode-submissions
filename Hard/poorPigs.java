/*
 * Poor Pigs - Given a number of buckets where one bucket is poisoned, find the minimum number of
 * pigs needed such that, when fed different buckets, you can find the poisoned bucket. A pig will
 * consume a buckets instantly, but takes minutesToDie amount of time to die, and you only have
 * minutesToTest given as time to do the tests.
 * 
 * As it happens, there is a math equation we can use to find the number of pigs every time, however
 * it is given in the problem's hints. We think of all the possible scenarios for each test. The total
 * number of tests in minutesToTest / minutesToDie + 1, and each test is done for all of the pigs, to
 * be greater than or equal to the number of buckets. We can rearrange the equation to solve for the
 * number of pigs, which gives us our equation.
 */

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil((Math.log(buckets)) / (Math.log((minutesToTest / minutesToDie) + 1.0)));
    }
}