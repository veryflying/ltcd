public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        int maj = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count != 0){
                if (nums[i] == maj)
                    count++;
                else 
                    count--;
            }
            else {
                maj = nums[i];
                count++;
            }
        }
        return maj;
    }
}