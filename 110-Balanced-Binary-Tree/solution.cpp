/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int height(TreeNode* p){
        if(p == NULL)
            return 0;
        int left = height(p->left);
        int right = height(p->right);
        if(left == -1 or right == -1 or abs(left - right) > 1 )
            return -1;
        return max(left, right) + 1;
    }
    bool isBalanced(TreeNode* root) {
        if(height(root) != -1)
            return true;
        else
            return false;
    }
};
