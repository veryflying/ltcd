
class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nl = root;
        while (nl != null){
            TreeLinkNode q = nl;
            nl = null;
            TreeLinkNode sew = new TreeLinkNode(0);
            boolean f = false;
            while (q != null){
                if (q.left != null && q.right != null){
                    if (!f){
                        f = true;
                        nl = q.left;
                    }
                    q.left.next = q.right;
                    sew.next = q.left;
                    sew = q.right;
                }
                else {
                    if (q.left != null || q.right != null){
                        sew.next = q.left != null? q.left: q.right;
                        sew = sew.next;
                        if (!f){
                            f = true;
                            nl = sew;
                        }
                    }
                }
                q = q.next;
            }
        }
    }
}