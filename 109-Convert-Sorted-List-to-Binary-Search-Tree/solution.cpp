/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode* build(ListNode* h, int l){
        if (l<=0)
            return NULL;
        ListNode* p = h;
        int i = 0;
        for (; i < l / 2; ++i) {
            p = p->next;
        }
        TreeNode* r = new TreeNode(p->val);
        r->left = build(h, i);
        r->right = build(p->next, l-i-1);
        return r;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        ListNode* p = new ListNode(NULL);
        p->next = head;
        int l = 0;
        while(p->next != NULL){
            l++;
            p = p->next;
        }
        return build(head, l);

    }
};