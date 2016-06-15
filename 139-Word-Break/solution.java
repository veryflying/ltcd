public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                if (wordDict.contains(s.substring(j,i+j+1))){
                    dp[j][i+j] = 1;
                    continue;
                }
                for (int k = j; k < i + j; k++) {
                    if (dp[j][k] == 1 && dp[k+1][i+j] == 1)
                    {
                        dp[j][i+j] = 1;
                        break;
                    }
                }
            }
        }
        return dp[0][s.length()-1] == 1;
    }
}