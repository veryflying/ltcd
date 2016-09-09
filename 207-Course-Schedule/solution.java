public class Solution {
    public void dfs(boolean[][] mtx, int i, boolean[] vis, int[] counts){
        vis[i] = true;
        for (int j = 0; j < mtx[i].length; j++) {
            if (mtx[i][j]){
                if (counts[j] == 1){
                    counts[j]--;
                    dfs(mtx, j, vis, counts);
                }
                else {
                    counts[j]--;
                }
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] mtx = new boolean[numCourses][numCourses];
        boolean[] vis = new boolean[numCourses];
        int[] counts = new int[numCourses];
        for (int[] edge :
                prerequisites) {
            if (!mtx[edge[1]][edge[0]]){
                mtx[edge[1]][edge[0]] = true;
                counts[edge[0]]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i] && counts[i] == 0){
                dfs(mtx, i, vis, counts);
            }
        }
        for (boolean e :
                vis) {
            if (!e)
                return false;
        }
        return true;
    }

}