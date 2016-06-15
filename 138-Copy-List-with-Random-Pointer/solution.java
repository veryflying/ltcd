public class Solution {
    Map<Integer, RandomListNode> table = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode h;
        if (!table.containsKey(head.label))
            h = new RandomListNode(head.label);
        else
            h = table.get(head.label);
        if (head.random != null)
        {
            RandomListNode t = new RandomListNode(head.random.label);
            table.put(t.label, t);
            h.random = t;
        }
        else
            h.random = null;
        h.next = copyRandomList(head.next);
        return h;
    }
}