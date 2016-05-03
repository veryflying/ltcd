public class Solution {
    public int maxProfit(int[] prices) {
        int min = 1<<30, pro = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            pro = Math.max(pro, prices[i]-min);
        }
        return pro;
    }
}