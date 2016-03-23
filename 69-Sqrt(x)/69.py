class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        f = 0
        for i in xrange(x):
            if i*i > x:
                return i-1
            elif i*i == x:
                return i