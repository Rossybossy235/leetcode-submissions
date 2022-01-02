class Solution {
    public String intToRoman(int num) {
        
        HashMap<Integer, String> romans = new LinkedHashMap();
        
        romans.put(1, "I");
        romans.put(4, "IV");
        romans.put(5, "V");
        romans.put(9, "IX");
        romans.put(10, "X");
        romans.put(40, "XL");
        romans.put(50, "L");
        romans.put(90, "XC");
        romans.put(100, "C");
        romans.put(400, "CD");
        romans.put(500, "D");
        romans.put(900, "CM");
        romans.put(1000, "M");
        
        String result = "";
        
        int nums[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        
        while (num > 0)
        {
            for (int i = nums.length - 1; i >= 0; i--)
            {
                if (nums[i] < num)
                {
                    result = result + romans.get(nums[i]);
                    num -= nums[i];
                    break;
                }
                else if (nums[i] == num)
                {
                    result = result + romans.get(nums[i]);
                    num -= nums[i];
                    break;
                }
            }
        }
        
        return result;
    }
}