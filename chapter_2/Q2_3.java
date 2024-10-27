/**
 * Tyler Spring
 * 10/27/2024
 * Chapter 2, Question 2.3: Delete Middle Node.
 * 
 * Implement an algorithm to delete a node in the middle 
 * (i.e., any node except the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node.
 */
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q2_3 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        //Delete the node with the value of 3 (middle node)
        ListNode nodeToDelete = head.next.next; // Node with value 3
        deleteNode(nodeToDelete);

        System.out.println("\nList after deleting node:");
        printList(head);
    }

    /**
     * Deletes a given node from the list by copying data from the next node
     * and adjusting the next pointer.
     */

     public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to be deleted cannot be null or the last node.");
        }

        //copy the data from the next node
        node.data = node.next.data;
        //skip the next node
        node.next = node.next.next;
     }

     //Function to print the linked list
     public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
     }
}
/**
 * Explanation:
 * What the problem asks:
 * You need to delete a given node in the middle of a singly linked list. However you do not
 * have access to the head of the list, only to the node you are asked to delete.
 * 
 * How it works:
 * You copy the data from the next node into the current Node.
 * Then you adjust the pointers to skip the next node, effectively removing it from the list.
 * 
 * Why it works:
 * Even though you do not have access to the head or the previous node,
 * copying the data and skipping the next node achieves the desired effect.
 * 
 * You CAN NOT use this approach if the node to delete is the last node in the list since 
 * there's no node to copy from.
 * This is an in-place operation, meaning it modifies the original list without creating a new one.
 */