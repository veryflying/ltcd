class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        f = 0
        i = 1
        j = 1
        while i < x:
            if i*i == x:
                return i
            elif i*i < x:
                j = i
                i = i<<1
            elif i*i > x:
                if i == j+1:
                    return j
                else:
                    i = (i + j)>>1