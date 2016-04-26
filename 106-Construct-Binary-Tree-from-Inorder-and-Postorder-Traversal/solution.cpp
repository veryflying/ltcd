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
    TreeNode* build(vector<int>::iterator pi, vector<int>::iterator pj, vector<int>::iterator ii, vector<int>::iterator ij) {
        if(pi > pj or ii > ij){
            return NULL;
        }
        int v = *pj;
        vector<int>::iterator i = find(ii, ij, v);
        TreeNode* p = new TreeNode(v);
        if (ii != i)
            p->left = build(pi, pi+(i-ii)-1, ii, i-1);
        if (ij != i)
            p->right = build(pi+(i-ii), pj-1, i+1, ij);
        return p;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (inorder.size() == 0)
            return NULL;
        return build(postorder.begin(), postorder.end()-1, inorder.begin(), inorder.end()-1);
    }
};