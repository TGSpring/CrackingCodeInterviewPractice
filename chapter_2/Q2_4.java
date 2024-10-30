/**
 * Tyler Spring
 * 10/30/2024
 * Chapter 2 Question 2.4: Partition Linked List.
 */
public class Q2_4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next =  new ListNode(1);   

        System.out.println("Original List:");
        printList(head);

        int partitionValue = 5;
        ListNode partitionedList = partition(head, partitionValue);

        System.out.println("\nList After Partitioning Around " + partitionValue + ":");
        printList(partitionedList);
    }

    //Function to partition the linked list around a value x
    public static ListNode partition (ListNode head, int x) {
        ListNode beforeStart = null; // Head of the "before" list
        ListNode beforeEnd = null; // Tail of the "before" list
        ListNode afterStart = null; // Head of the "after" list
        ListNode afterEnd = null; //.Tail of the "after" list

        //Iterate through the list and partition the nodes
        while(head != null) {
            ListNode next = head.next;
            head.next = null; //Detach the current nodes
            if(head.data < x) {
                //Insert node into the 'before' list
                if(beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            } else {
                //Insert node into the 'after' list
                if(afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }

        //Merge the two lists
        if(beforeStart == null) {
            return afterStart; //If no 'before' list, return the 'after' list
        }

        beforeEnd.next = afterStart; //Link the two list
        return beforeStart;
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
 * We taverse the original linked list.
 * If a nodes value is less than x, we add it to the before list.
 * If a nodes value is greater than x, we add it to the after list.
 * After partitioning the two lists, we merge them by connecting the end of the before List
 * to the start of the after list.
 */
