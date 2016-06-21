class Solution {
    int max(int s, int e, int[] nums){
        if (s > e)
            return 0;
        if (s == e)
            return nums[s];
        int i = s, j = e, ss = 1, es = 1, ms = 1, sum = 1;
        while (i <= j){
            if (nums[i] >= 0){
                ss *= nums[i];
                i++;
            }
            else
                break;
        }
        while (i <= j){
            if (nums[j] >= 0){
                es *= nums[j];
                j--;
            }
            else
                break;
        }
        for (int k = i + 1; k < j; k++) {
            ms *= nums[k];
        }
        if (ms < 0){
            sum = Math.max(ms * nums[i] * ss, ms * nums[j] * es);
        }
        else {
            if (i == j){
                sum = Math.max(ss, es);
            }
            else
                if (i < e)
                    sum = ss * nums[i] * ms * nums[j] * es;
                else
                    sum = ss;
        }
        return sum;
    }
    public int maxProduct(int[] nums) {
        int i = 0, j = i, max = -1<<30;
        while (j < nums.length){
            if (nums[j] != 0)
                j++;
            else {
                max = Math.max(max, 0);
                max = Math.max(max, max(i, j - 1, nums));
                i = j = j + 1;
            }
        }
        max = Math.max(max, max(i, j - 1, nums));
        return max;
    }
}
