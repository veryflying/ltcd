class Solution {
    public int findDuplicate(int[] nums) {
        int s = nums.length, f = s;
        do {
            s = nums[s-1];
            f = nums[nums[f-1]-1];
        }while (s != f);
        int n = nums.length;
        while (n != s){
            n = nums[n-1];
            s = nums[s-1];
        }
        return s;
    }
}