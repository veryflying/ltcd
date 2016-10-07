public class Solution {
    int[] ord;
    int oi = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ord = new int[numCourses];
        int[] in = new int[numCourses];
        int[][] g = new int[numCourses][numCourses];
        for (int[] e: prerequisites){
            if (g[e[1]][e[0]] == 0) {
                in[e[0]]++;
                g[e[1]][e[0]] = 1 + e[0];
            }
        }
        while (oi < numCourses){
            int t = numCourses;
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0)
                {
                    t = i;
                    break;
                }
            }
            if (t == numCourses)
                return new int[]{};
            in[t]--;
            for (int ed : g[t]) {
                if (ed != 0)
                    in[ed-1]--;
            }
            ord[oi++] = t;
        }
        return ord;
    }
}