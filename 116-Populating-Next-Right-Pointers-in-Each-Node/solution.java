class Solution {
    ArrayList list = new ArrayList();
    void dfs(TreeLinkNode p, int l){
        if (p == null)
            return;
        if (list.size() <= l){
            list.add(null);
        }
        p.next = (TreeLinkNode) list.get(l);
        list.set(l, p);
        dfs(p.right, l+1);
        dfs(p.left, l+1);
    }
    public void connect(TreeLinkNode root) {
        dfs(root, 0);
    }
}