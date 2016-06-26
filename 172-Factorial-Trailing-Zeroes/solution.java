public class Solution {
    public int trailingZeroes(int n) {
        int z = 0;
        while (n != 0){
            z += n = n/5;
        }
        return z;
    }
}