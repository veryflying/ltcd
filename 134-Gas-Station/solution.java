public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] t = new int[gas.length];
        for (int i = 0; i < t.length; i++) {
            t[i] = gas[i] - cost[i];
        }
        int sum = t[0], s = 0;
        int ind = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += t[i];
            s += t[i];
            if (sum < 0){
                sum = 0;
                ind = i+1;
            }
        }
        return s>=0? ind: -1;
    }
}