/*
 * Course Schedule III - Given a 2d array of courses with the amount of time to complete a course
 * and the required completion date, return the maximum number of courses that can be completed
 * on time.
 * 
 * We can use a greedy approach. We first sort the array by their required completion date, then
 * iterate through the list, placing each course's amount of time to complete it into a max-heap.
 * We also keep track of how much total time has been spent to complete the current number of courses.
 * If our counter exceeds the current course's required completion date, then we remove the course
 * with the highest time to complete it from our counter and heap. At the end, the heap will contain
 * the number of courses that we can complete on time, and we return its size.
 */

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (int[] a, int[] b) -> {return a[1] - b[1];});
        int day = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < courses.length; i++) {
            day += courses[i][0];
            heap.add(courses[i][0]);
            
            if (day > courses[i][1]) {
                day -= heap.poll();
            }
        }
        
        return heap.size();
    }
}