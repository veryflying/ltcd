class Solution {
public:
    vector<vector<int>> r;
    vector<int> stk;
    void dfs(TreeNode* root, int sum) {
        if(!root)
            return;
        stk.push_back(root->val);
        if (!root->left and !root->right)
        { if (sum == root->val) {
            r.push_back(stk);
        }
        } else {
            dfs(root->left, sum - root->val);
            dfs(root->right, sum - root->val);
        }
        stk.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        dfs(root, sum);
        return r;
    }
};