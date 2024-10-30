/**
 * Tyler Spring
 * 10/30/2024
 * Chapter 2 Question 2.5: Sum Lists - Reverse Order.
 */
public class Q2_5 {
    public static void main(String[] args) {
        //Create two numbers: (7->1->6) and (5-> 9->2)
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next = new ListNode(2);

        System.out.println("First numbers: ");
        printList(l1);

        System.out.println("Second number: ");
        printList(l2);

        ListNode res = addListsReverse(l1, l2);
        System.out.println("Sum (Reserve Order):");
        printList(res);
    }

    //Function to add two linked lists in reverse Order
    public static ListNode addListsReverse(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            } 
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            //Create a new node for the current digit

            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }
        return dummy.next;
    }

    //Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

//Class for the linked list node
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
/**
 * Explanation
 * We use a dummy node to keep track of the head of the resulting list.
 * We iterate through both input lists and sum corresponding digits;
 * If the sum is greater than or equal to 10, we carry the value to the next digit.
 * The loop continues until all the digits are processed and the carry is zero.
 * 
 * Time complexity: O(n), where n is the length of the longer list.
 */