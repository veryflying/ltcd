# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        p = root
        stack = [None]
        seq = []
        while p is not None and p.left is None:
            seq.append(p.val)
            p = p.right
        while p is not None:
            if p.left is not None:
                t = p.left
                p.left = None
                stack.append(p)
                p = t
            else:
                seq.append(p.val)
                if p.right is not None:
                    p = p.right
                else:
                    p = stack.pop()
        for i in xrange(1, len(seq)):
            if seq[i] <= seq[i-1]:
                return False
        return True