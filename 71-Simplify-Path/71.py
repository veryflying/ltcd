class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stk = []
        path = '/' + path.strip('/')
        i = 0
        while i < len(path):
            j = i+1
            while j < len(path):
                if 'a' <= path[j] <= 'z' or 'A' <= path[j] <= 'Z' or path[j] == '_' or path[j] == '.' or '0' <= path[j] <= '9':
                    break
                j += 1
            k = j
            while k < len(path):
                if 'a' <= path[k] <= 'z' or 'A' <= path[k] <= 'Z' or path[k] == '_' or path[k] == '.' or '0' <= path[k] <= '9':
                    k += 1
                else:
                    break
            if path[j:k] == '..':
                if len(stk) > 0:
                    stk.pop()
            elif path[j:k] not in ['.', '']:
                stk.append(path[j:k])
            i = k
        return '/' + '/'.join(stk)