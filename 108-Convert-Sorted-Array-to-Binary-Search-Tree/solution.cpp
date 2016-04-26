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
    TreeNode* gen(vector<int>& nums, int i, int j){
        if (i>j)
            return NULL;
        int mid = (i+j)/2;
        TreeNode* r = new TreeNode(nums[mid]);
        r->left = gen(nums, i, mid-1);
        r->right = gen(nums, mid+1, j);
        return r;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return gen(nums, 0, nums.size()-1);   
    }
};