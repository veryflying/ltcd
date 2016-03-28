class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        p, q = 0, 0
        need = {i:0 for i in t}
        has = {i:0 for i in t}
        for i in t:
            need[i] += 1
        c = 0
        m, mi = 1<<31, 0
        while q < len(s):
            if s[q] in need:
                has[s[q]] += 1
                if has[s[q]] <= need[s[q]]:
                    c += 1
                while c == len(t):
                    if q-p+1 < m:
                        m = q - p + 1
                        mi = p
                    if s[p] in need:
                        has[s[p]] -= 1
                        if has[s[p]] < need[s[p]]:
                            c -= 1
                    p += 1
            q += 1
        if m >= 1<<31:
            return ''
        else:
            return s[mi: mi+m]