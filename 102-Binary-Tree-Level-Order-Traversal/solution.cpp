void level(vector<vector<int>>&r, TreeNode* p, int i){
    if(p == NULL)
        return;
    if(r.size() <= i)
        r.push_back(vector<int>());
    r[i].push_back(p->val);
    level(r, p->left, i+1);
    level(r, p->right, i+1);
}
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> r;
        level(r, root, 0);
        return r;
    }
};