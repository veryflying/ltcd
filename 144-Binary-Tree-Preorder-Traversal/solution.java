public class Solution {
    List<Integer> r = new LinkedList<>();
    void travel(TreeNode root){
        if (root == null)
            return;
        r.add(root.val);
        travel(root.left);
        travel(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        travel(root);
        return r;
    }
}