class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        final int length = gas.length;
        
        int i;
        int balance = 0;
        int minBalance = balance;
        
        for (i = 0; i < length; i++)
        {
            balance += gas[i] - cost[i];
            minBalance = Math.min(minBalance, balance);
        }
        
        if (balance < 0)
        {
            return -1;
        }
        
        for (i = 0; i < length && minBalance < 0; i++)
        {
            minBalance -= gas[i] - cost[i];
        }
        
        return i;
    }
}