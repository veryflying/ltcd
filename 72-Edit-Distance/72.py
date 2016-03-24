class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        tmp = [[None] * (len(word2)+1) for i in xrange(len(word1)+1)]
        def solve(w1, w2):
            if tmp[len(w1)][len(w2)] != None:
                return tmp[len(w1)][len(w2)]
            if len(w1) * len(w2) == 0:
                t = abs(len(w1)-len(w2))
                tmp[len(w1)][len(w2)] = t
                return t
            if w1[0] == w2[0]:
                t = solve(w1[1:], w2[1:])
                tmp[len(w1)][len(w2)] = t
                return t
            else:
                t = 1 + min(solve(w1[1:], w2[1:]),
                            solve(w1[1:], w2),
                            solve(w1, w2[1:]))
                tmp[len(w1)][len(w2)] = t
                return t
        return solve(word1, word2)