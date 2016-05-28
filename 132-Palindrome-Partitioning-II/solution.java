
class Solution {
    String gs;
    int[][] dp;
    public int minCut(String s) {
        int[] temp = new int[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            temp[i] = i-1;
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; i - j>= 0 && j + i < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
                temp[i+j+1] = Math.min(temp[i+j+1], 1+temp[i-j]);
            }
            for (int j = 1; i - j + 1>= 0 && i + j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++) {
                temp[i+j+1] = Math.min(temp[i+j+1], 1+ temp[i-j+1]);
            }
        }
        return temp[s.length()];
    }
   
}