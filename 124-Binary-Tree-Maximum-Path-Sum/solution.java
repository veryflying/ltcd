public class Solution {
    int max = -1<<30;
    public int trl(TreeNode root) {
        if (root == null)
            return 0;

        int left = trl(root.left);
        int right = trl(root.right);
        max = Math.max(max, left + right + root.val);
        return (Math.max(left, right) + root.val) > 0? (Math.max(left, right) + root.val): 0;
    }
    public int maxPathSum(TreeNode root){
        trl(root);
        return max;
    }
}