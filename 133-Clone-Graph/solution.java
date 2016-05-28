public class Solution {
    Map<Integer, UndirectedGraphNode> created = new HashMap<>();
    void clone(UndirectedGraphNode r, UndirectedGraphNode node){
        for (UndirectedGraphNode e :
                node.neighbors) {
            if (created.containsKey(e.label)){
                r.neighbors.add(created.get(e.label));
            }
            else {
                UndirectedGraphNode c = new UndirectedGraphNode(e.label);
                r.neighbors.add(c);
                created.put(c.label, c);
                clone(c, e);
            }
        }
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        UndirectedGraphNode g = new UndirectedGraphNode(node.label);
        created.put(g.label, g);
        clone(g, node);
        return g;
    }
}