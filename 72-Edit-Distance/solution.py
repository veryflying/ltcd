class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        def solve(w1, w2):
            if len(w1) * len(w2) == 0:
                return abs(len(w1)-len(w2))
            if w1[0] == w2[0]:
                return solve(w1[1:], w2[1:])
            else:
                return 1 + min(solve(w1[1:], w2[1:]),
                            solve(w1[1:], w2),
                            solve(w1, w2[1:]))
        return solve(word1, word2)
