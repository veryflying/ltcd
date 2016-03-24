class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        i = 0
        j = len(matrix) * len(matrix[0]) - 1
        while i <= j:
            m = (i+j)/2
            r, c = m/len(matrix[0]), m%len(matrix[0])
            if matrix[r][c] > target:
                i = m + 1
            elif matrix[r][c] < target:
                j = m - 1
            else:
                return True
        return False