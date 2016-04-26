class Solution {
public:
    TreeNode* f(TreeNode* root){
        if (!root)
            return NULL;
        if (!root->left and !root->right)
            return root;
        if (root->left == NULL)
            return f(root->right);
        if (root->right == NULL) {
            root->right = root->left;
            root->left = NULL;
            return f(root->right);
        }
        TreeNode* left = root->left, *right = root->right;
        root->right = left;
        root->left = NULL;
        f(left)->right = right;
        return f(right);
    }
    void flatten(TreeNode* root) {
        f(root);
    }
};