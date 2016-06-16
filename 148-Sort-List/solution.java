class Solution {
    ListNode merge(ListNode l1, ListNode l2){
        ListNode h = new ListNode(-1), p = h;
        h.next = l1;
        while (p.next != null && l2 != null){
            if (p.next.val > l2.val){
                ListNode t = l2;
                l2 = l2.next;
                t.next = p.next;
                p.next = t;
            }
            else
            {
                p = p.next;
            }
        }
        if (p.next == null){
            if (l2 != null)
                p.next = l2;
        }
        return h.next;

    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode f = head, s = head;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        ListNode l1 = sortList(s.next);
        s.next = null;
        ListNode l2 = sortList(head);
        return merge(l1, l2);
    }
}
