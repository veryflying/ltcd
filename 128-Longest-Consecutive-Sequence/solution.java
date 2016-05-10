class Solution {
    int search(Map<Integer, Integer> hm, int v, int d){
        if (hm.containsKey(v)){
            hm.remove(v);
            if (d == 1)
                return search(hm, v+1, d) + 1;
            else
                return search(hm, v-1, d) + 1;
        }
        else
            return 0;
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int e :
                nums) {
            hm.put(e, 1);
        }
        int max = 0;
        for (int e :
                nums) {
            if (hm.containsKey(e)) {
                int count = 1;
                hm.remove(e);
                for (int i = e + 1; hm.containsKey(i); i++) {
                    count++;
                    hm.remove(i);
                }
                for (int i = e - 1; hm.containsKey(i); i--) {
                    count++;
                    hm.remove(i);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}