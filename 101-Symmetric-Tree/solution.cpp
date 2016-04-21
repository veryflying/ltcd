/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
bool isS(TreeNode* l, TreeNode* r){
    if(l == NULL or r == NULL)
        if(l == NULL and r == NULL)
            return true;
        else
            return false;
    if(l->val != r->val)
        return false;
    return isS(l->right, r->left) and isS(l->left, r->right);
}
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root == NULL)
            return true;
        return isS(root->left, root->right);
    }
};