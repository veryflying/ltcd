public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, m = nums.length + 1, sum = 0;
        boolean f = true;
        for (int j = 0; j < nums.length;){
            if (f)
                sum += nums[j];
            if (sum >= s)
            {
                m = Math.min(m, j - i + 1);
                sum -= nums[i];
                i++;
                f = false;
            }
            else{
                j++;
                f = true;
            }
        }
        if (m == nums.length + 1)
            return 0;
        return m;
    }
}