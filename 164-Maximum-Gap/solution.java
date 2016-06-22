
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int[] gapMax = new int[nums.length+1], gapMin = new int[nums.length+1];
        Arrays.fill(gapMax, Integer.MIN_VALUE);
        Arrays.fill(gapMin, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int e :
                nums) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        int gap = (int) Math.ceil(((float)max - min)/nums.length);
        if (gap == 0)
            return 0;
        for (int e: nums) {
            if (e == min)
            {
                gapMax[0] = Math.max(gapMax[0], e);
                gapMin[0] = Math.min(gapMin[0], e);
                continue;
            }
            if (e == max){
                gapMax[nums.length] = Math.max(gapMax[nums.length], e);
                gapMin[nums.length] = Math.min(gapMin[nums.length], e);
                continue;
            }

            int i = (e - min) / gap;
            gapMax[i] = Math.max(gapMax[i], e);
            gapMin[i] = Math.min(gapMin[i], e);
        }

        int i = 1, mgap = Integer.MIN_VALUE;
        while (i < nums.length) {
            for (; i < nums.length; i++) {
                if (gapMax[i] == Integer.MIN_VALUE)
                    break;
            }
            int j = i;
            for (; j < nums.length; j++) {
                if (gapMax[j] != Integer.MIN_VALUE)
                    break;
            }
            mgap = Math.max(mgap, gapMin[j] - gapMax[i-1]);
            i = j + 1;
        }
        return mgap;
    }
}
