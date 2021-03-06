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
                if 'a' <= path[j] <= 'z' or 'A' <= path[j] <= 'Z' or path[j] == '_' or path[j] == '.':
                    break
                j += 1
            k = j
            while k < len(path):
                if 'a' <= path[k] <= 'z' or 'A' <= path[k] <= 'Z' or path[k] == '_' or path[k] == '.':
                    k += 1
                else:
                    break
            if path[j:k] == '..':
                stk.pop()
            elif path[j:k] not in ['.', '']:
                stk.append(path[j:k])
            i = k
        return '/' + '/'.join(stk)