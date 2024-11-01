/**
 * Tyler Spring
 * 11/1/2024
 * Chapter 2 Question 2.6: Palindrome.
 * Reverse Half method
 */
public class Q2_6 {
    public static void main(String[] args) {
        // Create a linked list 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome: " + isPalindrome(head));
    }

    //Function to check if a list is a Palindrome.
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;

        //Step 1: Find the midpoint
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2: Reverse the second Half
        ListNode secondHalfStart = reverseList(slow);

        //Step 3: Compare the first and second half.
        ListNode firstHalfStart = head;
        ListNode secondHalfCurrent = secondHalfStart;

        while (secondHalfCurrent != null) {
            if (firstHalfStart.data != secondHalfCurrent.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfCurrent = secondHalfCurrent.next;
        }

        //Step 4: Optional - Restore the list.
        reverseList(secondHalfStart);

        return true;
    }

    //Function to reverse a linked list.
    public static ListNode reverseList(ListNode head){
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }
    return prev;
}
}

//Class for linked list node.
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
 * We locate the midpoint of the list using the slow and fast pointer technique.
 * reverse the second half and compare it to the first half node by node.
 * After the comparison, the list is optionally restored to its original order by reversing the second 
 * half again.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1), since we are only using pointers.
 */
