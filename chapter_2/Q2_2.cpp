/**
 * Tyler Spring
 * 10/27/2024
 * Chapter 2 Return kth to last: Implement an algorithm to find the kth to last
 * element of a singly linked list.
 */
#include <iostream>
using namespace std;

// Define the ListNode structure
struct ListNode {
    int data;
    ListNode* next;

    ListNode(int val) : data(val), next(nullptr) {}
};

class Index {
public:
    int value = 0;
};

// Recursive function to find the kth-to-last element
ListNode* kthToLastHelper(ListNode* head, int k, Index& idx) {
    if (head == nullptr) {
        return nullptr;
    }

    ListNode* node = kthToLastHelper(head->next, k, idx);
    idx.value++;

    if (idx.value == k) {
        return head;
    }
    return node;
}

// Wrapper function for cleaner recursion
ListNode* findKthToLastRecursive(ListNode* head, int k) {
    Index idx;
    return kthToLastHelper(head, k, idx);
}

// Function to print the list (for testing)
void printList(ListNode* head) {
    ListNode* current = head;
    while (current != nullptr) {
        cout << current->data << " -> ";
        current = current->next;
    }
    cout << "null" << endl;
}

int main() {
    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);

    cout << "Original List: ";
    printList(head);

    int k = 2;
    ListNode* res = findKthToLastRecursive(head, k);

    if (res != nullptr) {
        cout << "Kth to last element is: " << res->data << endl;
    } else {
        cout << "List is too short." << endl;
    }

    // Clean up
    ListNode* temp;
    while (head != nullptr) {
        temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}
/**
 * Explanation:
 * The function traverses to the end of the list using recursion
 * As the call stack unwinds, we increment the index
 * When the index matches k, we return that node
 * 
 * Index class:
 * we use an Index object to maintain a shared counter across recursive calls
 * 
 * Memory cleanup:
 * we manually free the allocated memory at the end to avoid memory leaks.
 */