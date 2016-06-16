import java.util.*;

class ListNode {
      int key, val;
      ListNode next, pre;
      ListNode(int x, int y) {
          key = x;
          val = y;
          next = null;
          pre = null;
      }
  }


public class LRUCache {

    ListNode head = new ListNode(-1, -1), tail = new ListNode(-1, -1);
    Map<Integer, ListNode> map = new HashMap<>();
    int cap, curcap;
    public LRUCache(int capacity) {
        cap = capacity;
        curcap = 0;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            ListNode t = map.get(key);
            t.pre.next = t.next;
            t.next.pre = t.pre;
            t.next = head.next;
            head.next.pre = t;
            head.next = t;
            t.pre = head;
            return t.val;
        }
        else 
            return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            ListNode t = map.get(key);
            t.val = value;
            t.pre.next = t.next;
            t.next.pre = t.pre;
            t.next = head.next;
            head.next.pre = t;
            head.next = t;
            t.pre = head;
        }
        else {
            ListNode t = new ListNode(key, value);
            t.next = head.next;
            head.next.pre = t;
            head.next = t;
            t.pre = head;
            map.put(key, t);
            if (curcap < cap){
                curcap++;
            }
            else {
                tail = tail.pre;
                tail.next.pre = null;
                tail.next = null;
                map.remove(tail.key);
            }
        }
    }
}