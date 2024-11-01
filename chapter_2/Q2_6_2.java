/**
 * Tyler Spring
 * 11/1/2024
 * Chapter 2 Question 2.6: Palindrome.
 * Stack method
 */
import java.util.*;

public class Q2_6_2 {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome: " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
    
        //Push the first half of the elements onto the stack
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //If odd number of elements, skip the middle element.
        if (fast != null) {
            slow = slow.next;
        }

        //Compare the stack with the second half of the list.
        while(slow != null) {
            int top = stack.pop();

            //If values are different, its not a palindrome.
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }
}
/**
 * Explanation:
 * First Half: As we reach the midpoint, each node's value is pushed onto a stack.
 * Skip middle element: If the list has an odd number of elements, fast will not be
 * null after the loop. In this case, we advance slow by one to skip the middle element.
 * Comparison: Starting from slow, we pop elements from the stack. Each popped value should match 
 * the current node's data in the list to satisfy the palindrome condition.
 * 
 * Time complexity: O(n)
 * Space Complexity: O(n) due to the stack storage. 
 */