public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int w = 0;
        while (n != 0){
            n &= n - 1;
            w++;
        }
        return w;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.hammingWeight(19));
//    }
}