/**
 * Tyler Spring
 * 11/2/2024
 * Chapter 2 Question 2.7
 * Intersection
 */
public class Q2_8 {
    public static void main(String[] args) {
         // Create a sample circular linked list
         ListNode head = new ListNode(3);
         head.next = new ListNode(1);
         head.next.next = new ListNode(5);
         head.next.next.next = new ListNode(9);
         ListNode loopStart = new ListNode(7);
         head.next.next.next.next = loopStart; // Beginning of the loop
         loopStart.next = new ListNode(2);
         loopStart.next.next = new ListNode(1);
         loopStart.next.next.next = loopStart; // Points back to the loop start, creating a cycle
 
         ListNode result = findLoopStart(head);
         if (result != null) {
             System.out.println("Loop starts at node with value: " + result.data);
         } else {
             System.out.println("No loop detected.");
         }
    }   

    public static ListNode findLoopStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //If slow and fast meet, there's a loop
            if (slow == fast) break;
        }

        //Check if no loop was found
        if (fast == null || fast.next == null) {
            return null;

        }

        //Reset slow pointer to the start of the list.
        slow = head;
        //Move both pointers at the same pace to find the start of the loop.
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //The point of intersection is the start of the loop.
        return slow;
    }
}

/**
 * Explanation:
 * Cycle Detection: Using the fast and slow pointers to detect if a cycle exists.
 * Finding loop start: Resetting one pointer to the head and moving both pointers step 
 * by step until they meet again at the loop start.
 * 
 * Time Complexity: O(n) as both pointers will traverse each node at most once.
 * Space Complexity: O(1) requiring no additional space beyond pointers.
 */
