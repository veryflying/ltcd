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
        if (nums.length == 0)
            return 0;
        dp_arr = new int[nums.length+1];
        dp_arr[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp_arr[i] = Math.max(dp_arr[i-1], dp_arr[i-2] + nums[i-1]);
        }
        return dp_arr[nums.length];
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.rob(new int[]{0}));
//    }
}