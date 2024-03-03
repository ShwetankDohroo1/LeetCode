/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int printingLength(ListNode* head){
        ListNode* temp = head;
        int count = 0;
        while(temp != NULL){
            count++;
            temp = temp->next;
        }
        return count;
    }
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int posi = printingLength(head) - n;
        ListNode* prev = NULL;
        ListNode* curr = head;
        if(posi == 0){
            ListNode* newHead = head->next;
            delete head;
            return newHead;
        }
        while(posi > 0){
            posi--;
            prev = curr;
            curr = curr->next;
        }
        if(prev != NULL){
            prev->next = curr->next;
            delete curr;
        }
        return head;
    }
};