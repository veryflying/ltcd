class Solution {
    public int maxProfit(int[] prices) {
        int j = 0, pro = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i+1]){
                if (i == j){
                    j++;
                }
                else {
                    pro += prices[i] - prices[j];
                    j = i + 1;
                }
            }
        }
        if (j < prices.length-1){
            pro += prices[prices.length-1] - prices[j];
        }
        return pro;
    }
}