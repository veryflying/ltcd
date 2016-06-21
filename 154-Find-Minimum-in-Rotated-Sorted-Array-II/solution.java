class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1, m = (i + j) / 2;
        while (i < j){
            if (nums[m] > nums[j]){
                i = m + 1;
            }
            else if (nums[m] < nums[j]){
                j = m;
            }
            else{
                j--;
            }
            m = (i + j) / 2 ;
        }
        return nums[m];
    }
}
