public class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1, mid = i + (j - i)/2;
        while (i < j){
            if (nums[mid] < nums[mid+1]){
                i = mid + 1;
            }
            else 
            {
                j = mid;
            }
            mid = i + (j - i)/2;
        }
        return j;
    }
}
