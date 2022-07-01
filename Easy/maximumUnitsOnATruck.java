/*
 * Maximum Units On a Truck - Given a 2d array of box types, containing the number of boxes of a 
 * certain type and the number of units that can be contained in a box of that type, and an integer
 * representing the maximum number of boxes that can be placed in a truck, find the maximum number of
 * units that can be put inside the truck.
 * 
 * We use a greedy approach. We first sort the array by the number of units per box in descending 
 * order. Then, we iterate through the sorted array, placing the largest boxes into the truck until
 * the truck is full and keeping track of the number of units placed into the truck. Once the truck
 * is full, our counter variable will have the maximum number of boxes that can be placed into the
 * truck.
 */

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        
        int numUnits = 0;
        int boxes = 0;
        
        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[i][0]; j++) {
                if (boxes == truckSize)
                    return numUnits;
                else {
                    boxes++;
                    numUnits += boxTypes[i][1];
                }
            }
        }
        
        return numUnits;
    }
}