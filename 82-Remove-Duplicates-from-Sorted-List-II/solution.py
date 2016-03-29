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
        p = ListNode(None)
        p.next = head
        head = p
        t = p.next.val
        f = 0
        while p.next is not None and p.next.next is not None:
            if t == p.next.next.val:
                f = 1
                delete_next(p)
            else:
                if f == 1:
                    delete_next(p)
                    f = 0
                else:
                    p = p.next
                t = p.next.val
        if f == 1:
            delete_next(p)
        return head.next