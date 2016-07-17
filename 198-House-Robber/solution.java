import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    int[] dp_arr;
    int dp(int[] nums, int i){
        if (i >= nums.length)
            return 0;
        if (dp_arr[i] != -1)
            return dp_arr[i];
        return dp_arr[i] = Math.max(nums[i] + dp(nums, i + 2), dp(nums, i+1));
    }
    public int rob(int[] nums) {
        dp_arr = new int[nums.length];
        Arrays.fill(dp_arr, -1);
        return dp(nums, 0);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.rob(new int[]{0}));
//    }
}