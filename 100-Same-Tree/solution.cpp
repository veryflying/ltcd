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
bool isS(TreeNode* p, TreeNode* q){
    if(p == NULL or q == NULL)
    if(p == NULL and q == NULL)
        return true;
    else
        return false;
    if(p->val != q->val)
        return false;
    return isS(p->left, q->left) and isS(p->right, q->right);
}
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        return isS(p, q);
    }
};