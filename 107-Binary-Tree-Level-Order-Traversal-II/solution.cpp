class Solution {
public:
    void bfs(vector<vector<int>>& r, TreeNode* p, int l){
        if (p == NULL)
            return;
        if (r.size()<=l)
            r.push_back({});

        bfs(r, p->left, l+1);
        bfs(r, p->right, l+1);
        r[l].push_back(p->val);
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> r;
        bfs(r, root, 0);
        reverse(r.begin(), r.end());
        return r;
    }
};