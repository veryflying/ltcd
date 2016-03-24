class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        tmp = []
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                if matrix[i][j] == 0:
                    tmp.append((i, j))
        for i in tmp:
            for j in xrange(len(matrix[0])):
                matrix[i[0]][j] = 0
            for j in xrange(len(matrix)):
                matrix[j][i[1]] = 0