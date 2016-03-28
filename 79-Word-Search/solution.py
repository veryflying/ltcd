class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        tmp = [[0 for i in xrange(len(board[0]))] for j in xrange(len(board))]
        def dfs(i, j, k):
            if k == len(word):
                return True
            if i >= len(board) or i < 0 or j >= len(board[0]) or j < 0:
                return False
            if tmp[i][j] == 1:
                return False
            tmp[i][j] = 1
            if board[i][j] != word[k]:
                tmp[i][j] = 0
                return False
            else:
                if dfs(i-1, j, k+1) or dfs(i+1, j, k+1) or dfs(i, j-1, k+1) or dfs(i, j+1, k+1):
                    return True
                tmp[i][j] = 0
                return False
        for i, row in enumerate(board):
            for j, item in enumerate(row):
                if item == word[0]:
                    if dfs(i, j, 0):
                        return True
        return False
