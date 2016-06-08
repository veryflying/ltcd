public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r = r ^ nums[i];
        }
        return r;
    }
}