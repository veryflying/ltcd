public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = 0;
        for (; i < numbers.length; i++){
            if (numbers[i] > target/2)
                break;
            j = search(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1)
                break;
        }
        return new int[]{i+1, j+1};
    }
    public int search(int[] num, int i, int j, int t){
        if (i > j)
            return -1;
        int m = (i + j) / 2;
        if (t == num[m])
            return m;
        if (t > num[m])
            return search(num, m + 1, j, t);
        if (t < num[m])
            return search(num, i, m - 1, t);
        return -1;
    }
}