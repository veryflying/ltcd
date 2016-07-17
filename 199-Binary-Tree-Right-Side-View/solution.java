import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode l = root;
        while (true){
            TreeNode t = q.poll();
            if (t == null){
                res.add(l.val);
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else {
                l = t;
                if (t.left != null){
                    q.add(t.left);
                }
                if (t.right != null){
                    q.add(t.right);
                }
            }
        }
        return res;
    }
}