
import java.util.Arrays;

class Solution {

    int[][] hp;
    public int dp(int[][] d, int i, int j){
        if (hp[i][j] != Integer.MAX_VALUE)
            return hp[i][j];
        int r = j+1 < d[0].length? dp(d, i, j+1): Integer.MIN_VALUE, dn = i+1 < d.length? dp(d, i+1, j): Integer.MIN_VALUE;
        return hp[i][j] = r == dn && r == Integer.MIN_VALUE ? d[i][j]: Math.min(d[i][j], d[i][j] + Math.max(r, dn));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        hp = new int[dungeon.length][dungeon[0].length];
        for (int[] r :
                hp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        return 1 - Math.min(dp(dungeon, 0, 0), 0);
    }

   
}