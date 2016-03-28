class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        def recs(i, j):
            if j == 1:
                return [[i]]
            r = []
            for l in xrange(1,i):
                for item in recs(l, j-1):
                    item.append(i)
                    r.append(item)
            return r
        r = []
        for i in xrange(1, n+1):
            r += recs(i, k)
        return r