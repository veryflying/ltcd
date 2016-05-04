class Solution {
    ArrayList<Integer> p = new ArrayList<Integer>();
    int[][] dp;
    int mx(int pos, int c){
        if (dp[pos/2][c] != -1)
            return dp[pos/2][c];
        if (c == 1){
            int min = 1<<30, pro = 0;
            for (int i = pos; i < p.size(); i += 2) {
                min = Math.min(p.get(i), min);
                pro = Math.max(p.get(i+1) - min, pro);
            }
            return dp[pos/2][c] = pro;
        }

        int max = 0;
        for (int i = pos+1; i < p.size(); i += 2) {
            int t = mx(i+1, c-1);
            max = Math.max(max, p.get(i) - p.get(pos) + t);
        }
        return dp[pos/2][c] = max;
    }
    public int maxProfit(int[] prices) {
        int j = 0, pro = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] >= prices[i+1]){
                if (i == j){
                    j++;
                }
                else {
                    p.add(prices[j]);
                    p.add(prices[i]);
                    j = i + 1;
                }
            }
        }
        if (j < prices.length-1){
            p.add(prices[j]);
            p.add(prices[prices.length-1]);
        }
        dp = new int[p.size()/2+1][3];
        for (int[] r: dp){
            Arrays.fill(r, -1);
        }
        int max = 0;
        for (int i = 0; i < p.size(); i += 2) {
            max = Math.max(max, mx(i, 2));
        }
        return max;
    }
}