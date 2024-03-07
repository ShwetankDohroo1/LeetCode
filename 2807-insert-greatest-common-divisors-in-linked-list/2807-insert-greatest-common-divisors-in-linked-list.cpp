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
    int gcd(int a,int b){
        int result = min(a, b); 
        while(result > 0){ 
            if(a % result == 0 && b % result == 0){ 
                break; 
            } 
            result--; 
        }    
        return result;
    }
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if(head == nullptr || head->next == nullptr) {
        return head;
    }
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast != nullptr){
            ListNode* newNode = new ListNode(gcd(slow->val,fast->val));
            slow->next = newNode;
            newNode->next = fast;
            slow = fast;
            fast = fast->next;
        }
        return head;
    }
};