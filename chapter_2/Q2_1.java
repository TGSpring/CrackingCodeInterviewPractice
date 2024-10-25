/**
 * Tyler Spring
 * 10/18/2024
 * Chapter 2 practice questions: Remove Duplicates from an Unsorted Linked List (No Buffer).
 */

public class Q2_1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);

        System.out.println("Original List:");
        printList(head);

        removeDuplicates(head);

        System.out.println("\nList After Removing Duplicates");
        printList(head);
    }

    public static void removeDuplicates(ListNode head) {
        ListNode current = head;

        // Outer loop: Iterate over the entire list
        while (current != null) {
            ListNode runner = current;

            // Inner Loop: Check subsequent nodes for Duplicates
            while (runner.next != null ) {
                if(runner.next.data == current.data) {
                    //skip the duplicate node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
/**
 * Explanation:
 * 
 * 1. Outer Loop (current):
 *      Iterates through each node in the list.
 * 2. Inner Loop (runner):
 *      For each node current, the runner checks all subsequent nodes for duplicates.
 *      If a duplicate is found, we skip it by adjusting the next pointer of the runner.
 * 3. Time complexity:
 *      O(n^2): For each node, we scan the remaining nodes for duplicates.
 * 4. Space Complexity: O(1): No additional data structures are used.
 * 
 * Why this is harder:
 * The nested loops make this version slower, with O(n^2) time complexity.
 * The lack of a buffer forces us to manually track each duplicate with 
 * the runner pointer, which requires more careful pointer manipulation.
 */