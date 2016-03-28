class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        tmp = [[0 for i in xrange(len(board[0]))] for j in xrange(len(board))]
        def dfs(i, j, k):
            if k == len(word)-1 and board[i][j] == word[k]:
                return True
            if tmp[i][j] == 1:
                return False
            tmp[i][j] = 1
            if board[i][j] != word[k]:
                return False
            else:
                if i > 0:
                    if dfs(i-1, j, k+1):
                        return True
                if i < len(board)-1:
                    if dfs(i+1, j, k+1):
                        return True
                if j > 0:
                    if dfs(i, j-1, k+1):
                        return True
                if j < len(board[0])-1:
                    if dfs(i, j+1, k+1):
                        return True
                return False
        for i, row in enumerate(board):
            for j, item in enumerate(row):
                if item == word[0]:
                    if dfs(i, j, 0):
                        return True
        return False