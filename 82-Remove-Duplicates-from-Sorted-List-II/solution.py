# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        def delete_next(node_i):
            t = node_i.next
            node_i.next = t.next
        p = head
        while p.next is not None and p is not None:
            if p.val == p.next.val:
                delete_next(p)
            else:
                p = p.next
        return head