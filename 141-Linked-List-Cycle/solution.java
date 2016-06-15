public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode f, s;
        if (head != null && head.next != null)
        {
            f = head.next;
            s = head;
        } 
        else 
        return false;
        while (s != f){
            if (f.next != null)
                f = f.next.next;
            else return false;
            s = s.next;
            if (f == null)
                return false;
        }
        return true;
    }
}