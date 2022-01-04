class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int current1 = 0;
        int current2 = 0;
        int length = m;
        
        while (length < nums1.length && current2 < n && current1 < nums1.length)
        {
            int numOne = nums1[current1];
            int numTwo = nums2[current2];
            
            if (numTwo < numOne)
            {
                for (int i = length; i > current1; i--)
                {
                    nums1[i] = nums1[i - 1];
                }
                
                nums1[current1] = numTwo;
                current2++;
                length++;
            }
            current1++;
        }
        
        if (current2 < n)
        {
            int temp = current2;
            
            for (int i = m + current2; i < nums1.length; i++)
            {
                nums1[i] = nums2[temp];
                temp++;
            }
        }
    }
}