class Solution {
public:
    int height(TreeNode* p){
        if(p == NULL)
            return 0;
        int left = 1<<31, right = 1<<31;
        left = height(p->left);
        right = height(p->right);
        if (p->left == NULL)
            return right + 1;
        if (p->right == NULL)
            return left + 1;
        return min(left, right) + 1;
    }
    int minDepth(TreeNode* root) {
        return height(root);
    }
};