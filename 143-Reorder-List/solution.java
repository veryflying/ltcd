class Solution {

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode f, s;
        f = s = head;
        while (true){
            if (f.next != null)
                if (f.next.next == null){
                    break;
                }
                else
                    f = f.next.next;
            else
            {
                break;
            }
            s = s.next;
        }
        if (head == s)
            return;
        ListNode h = s, p = h.next, t, l;
        if (p != null)
            while (p.next != null){
                t = p.next;
                l = h.next;
                h.next = t;
                p.next = t.next;
                t.next = l;
            }


        while (head.next != null && h.next != null && head != h){
            t = h.next;
            h.next = t.next;
            t.next = head.next;
            head.next = t;
            head = head.next.next;
        }

    }
}
