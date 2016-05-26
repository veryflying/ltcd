class Solution {
    char[][] bd;
    void dfs(int i,int j){
        if (i < 0 || j < 0 || i >= bd.length || j >= bd[0].length)
            return;
        bd[i][j] = '*';
        if (i < bd.length-1 && bd[i+1][j] == 'O')
            dfs(i+1, j);
        if (j < bd[0].length-1 && bd[i][j+1] == 'O')
            dfs(i, j+1);
        if (i > 0 && bd[i-1][j] == 'O')
            dfs(i-1, j);
        if (j > 0 && bd[i][j-1] == 'O')
            dfs(i, j-1);
    }
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        bd = board;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i <= board.length-1; i++) {
            for (int j = 0; j <= board[0].length-1; j++) {
                if (i == 0 || j == 0 || i == bd.length-1 || j == bd[0].length-1)
                {
                    if (board[i][j] == 'O')
                    {
//                        board[i][j] = '*';
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!q.isEmpty())
        {
            int[] e = q.poll();
            board[e[0]][e[1]] = '*';
            if (e[0] > 0 && board[e[0]-1][e[1]] == 'O')
                q.offer(new int[]{e[0]-1, e[1]});
            if (e[0] < board.length-1 && board[e[0]+1][e[1]] == 'O')
                q.offer(new int[]{e[0]+1, e[1]});
            if (e[1] > 0 && board[e[0]][e[1]-1] == 'O')
                q.offer(new int[]{e[0], e[1]-1});
            if (e[1] < board[0].length-1 && board[e[0]][e[1]+1] == 'O')
                q.offer(new int[]{e[0], e[1]+1});
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bd[i][j] == '*')
                    bd[i][j] = 'O';
                else
                    bd[i][j] = 'X';
            }
        }
    }
}
