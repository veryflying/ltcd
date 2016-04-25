#include <cstdio>
#include <iostream>
#include <cstring>
#include <cmath>
#include <string>
#include <cstdlib>
#include <algorithm>
#include <map>
#include <set>
#include <utility>
#include <vector>
#include <queue>
using namespace std;
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
        int v = *pi;
        vector<int>::iterator i = find(ii, ij, v);
        TreeNode* p = new TreeNode(v);
        if (ii != i)
            p->left = build(pi+1, pi+(i-ii), ii, i-1);
        if (ij != i)
            p->right = build(pi+(i-ii)+1, pj, i+1, ij);
        return p;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.size() == 0)
            return NULL;
        TreeNode* r = build(preorder.begin(), preorder.end()-1, inorder.begin(), inorder.end()-1);
        return r;
    }
};