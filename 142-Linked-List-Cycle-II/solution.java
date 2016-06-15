/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head, s = head;
        while (f != null){
            if (f.next != null)
                f = f.next.next;
            else
                return null;
            s = s.next;
            if (f == s)
                break;
        }
        if (f == null)
            return null;
        f = head;
        while (f != s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}