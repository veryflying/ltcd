public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rot(nums, 0, nums.length - k - 1);
        rot(nums, nums.length - k, nums.length - 1);
        rot(nums, 0, nums.length - 1);
    }
    public void rot(int[] nums, int i, int j){
        if (i < 0)
            i = 0;
        while (i < j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}