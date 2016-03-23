class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        t = [None] * (n+1)
        def s(i):
            if t[i] is not None:
                return t[i]
            if i >= n-2:
                t[i] = n - i
                return n - i
            t[i] = s(i+1) + s(i+2)
            return t[i]
        return s(0)