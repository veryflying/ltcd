import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] vis;
    void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] == 1){
            return;
        }
        vis[i][j] = 1;
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        vis = new int[grid.length][grid[0].length];
        int cnt = 0;
        Queue<int[]> q;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && vis[i][j] != 1){
                    cnt++;
                    q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    vis[i][j] = 1;
                    while (!q.isEmpty()){
                        int[] t = q.poll();
                        if (t[0] + 1 >= 0 && t[0] + 1 < grid.length && t[1] >= 0 && t[1] < grid[0].length && grid[t[0] + 1][t[1]] == '1' && vis[t[0] + 1][t[1]] != 1){
                            vis[t[0]+1][t[1]] = 1;
                            q.add(new int[]{t[0]+1, t[1]});
                        }
                        if (t[0] - 1 >= 0 && t[0] - 1 < grid.length && t[1] >= 0 && t[1] < grid[0].length && grid[t[0] - 1][t[1]] == '1' && vis[t[0] - 1][t[1]] != 1){
                            vis[t[0]-1][t[1]] = 1;
                            q.add(new int[]{t[0]-1, t[1]});
                        }
                        if (t[0] >= 0 && t[0] < grid.length && t[1] + 1 >= 0 && t[1] + 1 < grid[0].length && grid[t[0]][t[1] + 1] == '1' && vis[t[0]][t[1] + 1] != 1){
                            vis[t[0]][t[1]+1] = 1;
                            q.add(new int[]{t[0], t[1]+1});
                        }
                        if (t[0] >= 0 && t[0] < grid.length && t[1] - 1 >= 0 && t[1] - 1 < grid[0].length && grid[t[0]][t[1] - 1] == '1' && vis[t[0]][t[1] - 1] != 1){
                            vis[t[0]][t[1]-1] = 1;
                            q.add(new int[]{t[0], t[1]-1});
                        }
                    }
                }
            }
        }
        return cnt;
    }

   
}