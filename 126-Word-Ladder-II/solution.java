class Solution {
    boolean con(String a, String b){
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                c++;
            if (c >= 2)
                return false;
        }
        return true;
    }
    int[] temp;
    ArrayList<Integer>[] g;
    List<List<Integer>> r = new ArrayList<>();
    int[] tr;
    int si = 0;
    void dfs(int i, int l){
        if (i == 0){
            List<Integer> tmp = new ArrayList<>(tr.length);
            for (int j = 0; j < tr.length; j++) {
                tmp.add(tr[j]);
            }
            r.add(tmp);
        }
        for (int j = 0; j < g[i].size(); j++) {
            if (temp[g[i].get(j)] == l-1){
                tr[si++] = i;
                dfs(g[i].get(j), l-1);
                si--;
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        g = new ArrayList[wordList.size()+2];
        for (int i = 0; i < wordList.size() + 2; i++) {
            g[i] = new ArrayList<>();
        }
        temp = new int[wordList.size()+2];
        int[] vis = new int[wordList.size()+2];
        ArrayList<String> wl = new ArrayList<>(wordList.size()+2);
        wl.add(beginWord);
        for (String e:wordList) {
            wl.add(e);
        }
        wl.add(endWord);
        for (int i = 0; i < wl.size(); i++) {
            for (int j = i+1; j < wl.size(); j++) {
                if (con(wl.get(i), wl.get(j))){
                    if (!g[i].contains(j))
                        g[i].add(j);
                    if (!g[j].contains(i))
                        g[j].add(i);
                }
            }
        }
        int size = (wordList.size() + 3)*2;
        int[] q = new int[size];
        q[0] = 0;
        q[1] = -1;
        int i = 0, j = 2, l = 0;
        vis[0] = 1;
        while (!(q[i] == -1 && q[j] == -1)){
            int t = q[i];
            i = (i + 1) % size;
            if (t == -1){
                l++;
                q[j] = -1;
                j = (j + 1) % size;
                continue;
            }
            temp[t] = l;
            for (int k = 0; k < g[t].size(); k++) {
                if (vis[g[t].get(k)] == 0)
                {
                    vis[g[t].get(k)] = 1;
                    q[j] = g[t].get(k);
                    j = (j+1) % size;
                }
            }
        }
        tr = new int[temp[temp.length-1]];
        dfs(temp.length-1, temp[temp.length-1]);

        List<List<String>> res = new ArrayList<>();
        for (int k = 0; k < r.size(); k++) {
            List<String> tt = new ArrayList<>();
            tt.add(beginWord);
            for (int m = r.get(k).size()-1; m >= 0; m--) {
                tt.add(wl.get(r.get(k).get(m)));
            }
            res.add(tt);
        }
        return res;
    }
}