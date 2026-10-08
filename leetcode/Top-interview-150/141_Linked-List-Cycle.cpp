
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    bool hasCycle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast != nullptr) {
            slow = slow->next;
            fast = fast->next;
            if (fast == nullptr) return false;
            fast = fast->next;

            if (slow == fast) return true;
        }

        return false;
    }
};