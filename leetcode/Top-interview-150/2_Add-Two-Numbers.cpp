#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode dummy(0);
        ListNode* current = &dummy;
        int carry = 0;

        while (l1 || l2 || carry) {
            int sum = carry;

            if (l1) {
                sum += l1->val;
                l1 = l1->next;
            }
            if (l2) {
                sum += l2->val;
                l2 = l2->next;
            }

            carry = sum / 10;
            current->next = new ListNode(sum % 10);
            current = current->next;
        }

        return dummy.next;
    }
};

int main() {
    ListNode* l1_3 = new ListNode(9);
    ListNode* l1_2 = new ListNode(9, l1_3);
    ListNode* l1_1 = new ListNode(9, l1_2);

    ListNode* l2_3 = new ListNode(9);
    ListNode* l2_2 = new ListNode(9, l2_3);
    ListNode* l2_1 = new ListNode(9, l2_2);

    Solution s = Solution();

    ListNode* last = s.addTwoNumbers(l1_1, l2_1);
    while (last != nullptr) {
        std::cout << last->val;
        last = last->next;
    }
}