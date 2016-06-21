public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0, b = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null){
            pa = pa.next;
            a++;
        }
        while (pb != null){
            pb = pb.next;
            b++;
        }
        pa = headA; pb = headB;
        if (a > b){
            int t = a - b;
            while (t > 0){
                pa = pa.next;
                t--;
            }
        }
        else {
            int t = b - a;
            while (t > 0){
                pb = pb.next;
                t--;
            }
        }
        while (pa != pb){
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}