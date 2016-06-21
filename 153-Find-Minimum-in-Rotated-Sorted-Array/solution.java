class Solution {
    public int findMin(int[] nums) {
        if (nums.length <= 2){
            return nums.length == 1? nums[0]: Math.min(nums[0], nums[1]);
        }
        int i = 0, j = nums.length - 1, m = 1;
        while ((m > 0) && (m < nums.length-1) && !(nums[m] < nums[m-1])){
            if (nums[m] > nums[0]){
                i = m + 1;
            }
            else {
                j = m - 1;
            }
            m = (i + j) / 2 ;
        }
        if (m == nums.length-1)
            return Math.min(nums[0], nums[nums.length-1]);
        return nums[m];
    }
}