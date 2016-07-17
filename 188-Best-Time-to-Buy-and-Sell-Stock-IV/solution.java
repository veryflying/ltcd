public class Solution {
    int[][] dp;
//    public int mp(int k, int[] prices, int d) {
//        if (k == -1)
//            return 0;
//        if (d >= prices.length)
//            return 0;
//        if (dp[k][d] != -1<<20)
//            return dp[k][d];
//        int profit = 0;
//        for (int i = d+1; i < prices.length; i++) {
//            profit = Math.max(profit, prices[i] - prices[d] + mp(k-1, prices, i));
//        }
//        profit = Math.max(profit, mp(k, prices, d+1));
//        return dp[k][d] = profit;
//    }
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length/2)
        {
            int tmp = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    tmp += prices[i] - prices[i-1];
            }
            return tmp;
        }
        dp = new int[k+1][prices.length];
        for (int i = 1; i <= k; i++) {
            int prof = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] =  Math.max(prof + prices[j], dp[i][j-1]);
                prof = Math.max(prof, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
}