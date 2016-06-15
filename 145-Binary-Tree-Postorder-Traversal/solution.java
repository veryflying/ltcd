public class Solution {
    List<Integer> r = new LinkedList<>();
    void travel(TreeNode root){
        if (root == null)
            return;
        travel(root.left);
        travel(root.right);
        r.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        travel(root);
        return r;
    }
}