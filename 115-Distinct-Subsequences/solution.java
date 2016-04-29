class Solution {
    int [][]tmp;
    int dict(String s, int i, String t, int j){
        if (t.length() == j)
            return 1;
        if (s.length() - i < t.length() - j)
            return 0;
        if (s.length() - i == t.length() - j)
            return s.substring(i).equals(t.substring(j))? 1: 0;
        int sum = 0;
        if (s.charAt(i) == t.charAt(j)){
            sum += dict(s, i+1, t, j+1);
        }
        sum += dict(s, i+1, t, j);
        return sum;
    }
    public int numDistinct(String s, String t) {
        tmp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            tmp[i][t.length()] = 1;
        }
        for (int j = t.length()-1; j >= 0 ; j--) {
            for (int i = s.length()-1; i >= 0; ) {
                if (s.charAt(i) == t.charAt(j)){
                    tmp[i][j] += tmp[i+1][j+1] + tmp[i+1][j];
                    i--;
                }
                else {
                    tmp[i][j] += tmp[i+1][j];
                    i--;
                }
            }
        }
        return tmp[0][0];
    }
}