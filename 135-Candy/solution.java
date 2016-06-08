public class Solution {
    public int candy(int[] ratings) {
        int[] c = new int[ratings.length];
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i+1] > ratings[i])
                c[i+1] = c[i] + 1;
        }
        for (int i = ratings.length-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i])
                c[i-1] = Math.max(c[i]+1, c[i-1]);
        }
        int sum = ratings.length;
        for (int e :
                c) {
            sum += e;
        }
        return sum;
    }
}