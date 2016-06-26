public class Solution {
    public String convertToTitle(int n) {
        String r = "";
        while (n != 0){
            n = n - 1;
            r = (char) ('A' + n % 26) + r;
            n = n / 26;
        }
        return r;
    }
}